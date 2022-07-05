package ru.job4j.ood.lsp.store;

public class Trash extends AbstractStore {

    @Override
    protected boolean isValid(Food food) {
        return freshnessRatio(food) > LOW_FRESHNESS_RATIO;
    }
}
