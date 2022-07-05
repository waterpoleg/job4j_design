package ru.job4j.ood.lsp.store;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public abstract class AbstractStore {

    static final int DISCOUNT = 15;
    static final int HIGH_FRESHNESS_RATIO = 25;
    static final int MEDIUM_FRESHNESS_RATIO = 75;
    static final int LOW_FRESHNESS_RATIO = 100;

    private final List<Food> foods = new ArrayList<>();

    protected abstract boolean isValid(Food food);

    List<Food> getAllFood() {
        return new ArrayList<>(foods);
    }

    boolean addFood(Food food) {
        var result = false;
        if (isValid(food)) {
            foods.add(food);
            result = true;
        }
        return result;
    }

    int freshnessRatio(Food food) {
        var expiryDays = DAYS.between(food.getExpireDate(), food.getCreateDate());
        var currentDays = DAYS.between(LocalDate.now(), food.getCreateDate());
        return (int) (currentDays * 100 / expiryDays);
    }
}
