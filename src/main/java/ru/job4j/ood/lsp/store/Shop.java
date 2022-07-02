package ru.job4j.ood.lsp.store;

import java.util.ArrayList;
import java.util.List;

import static ru.job4j.ood.lsp.store.Constants.*;

public class Shop implements Store {

    private List<Food> foods = new ArrayList<>();

    @Override
    public List<Food> getAll() {
        return new ArrayList<>(foods);
    }

    @Override
    public boolean add(Food food) {
        var result = false;
        var freshness = freshnessRatio(food);
        if (freshness >= HIGH_FRESHNESS_RATIO.getValue() && freshness <= LOW_FRESHNESS_RATIO.getValue()) {
            if (freshness >= MEDIUM_FRESHNESS_RATIO.getValue()) {
                food.setDiscount(DISCOUNT.getValue());
            }
            foods.add(food);
            result = true;
        }
        return result;
    }

    @Override
    public void clearStorage() {
        foods.clear();
    }
}
