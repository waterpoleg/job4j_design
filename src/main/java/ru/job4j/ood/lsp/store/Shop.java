package ru.job4j.ood.lsp.store;

public class Shop extends AbstractStore {

    @Override
    protected boolean isValid(Food food) {
        var result = false;
        var freshness = freshnessRatio(food);
        if (freshness >= HIGH_FRESHNESS_RATIO && freshness <= LOW_FRESHNESS_RATIO) {
            if (freshness >= MEDIUM_FRESHNESS_RATIO) {
                food.setDiscount(DISCOUNT);
            }
            result = true;
        }
        return result;
    }
}
