package ru.job4j.ood.lsp.store;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {

    private List<Food> foods = new ArrayList<>();

    @Override
    public List<Food> getAll() {
        return new ArrayList<>(foods);
    }

    @Override
    public boolean add(Food food) {
        var result = false;
        if (freshnessRatio(food) < Constants.HIGH_FRESHNESS_RATIO.getValue()) {
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
