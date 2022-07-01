package ru.job4j.ood.lsp.store;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    private List<Food> foods;

    @Override
    public List<Food> getAll() {
        return new ArrayList<>(foods);
    }

    @Override
    public boolean add(Food food) {
        var result = false;
        var freshness = freshnessRatio(food);
        if (freshness >= HIGH_FRESHNESS_RATIO && freshness <= LOW_FRESHNESS_RATIO) {
            if (freshness >= MEDIUM_FRESHNESS_RATIO) {
                food.setDiscount(DISCOUNT);
            }
            foods.add(food);
            result = true;
        }
        return result;
    }

    @Override
    public void clearStorage() {
        foods = new ArrayList<>();
    }
}
