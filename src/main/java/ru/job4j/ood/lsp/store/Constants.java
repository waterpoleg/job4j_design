package ru.job4j.ood.lsp.store;

public enum Constants {

    DISCOUNT(15),
    HIGH_FRESHNESS_RATIO(25),
    MEDIUM_FRESHNESS_RATIO(75),
    LOW_FRESHNESS_RATIO(100);

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
