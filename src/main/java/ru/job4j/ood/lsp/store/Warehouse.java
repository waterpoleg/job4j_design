package ru.job4j.ood.lsp.store;

public class Warehouse extends AbstractStore {

    @Override
    protected boolean isValid(Food food) {
        return freshnessRatio(food) < HIGH_FRESHNESS_RATIO;
    }
}
