package ru.job4j.ood.lsp.store;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public interface Store {

    double DISCOUNT = 15;
    double HIGH_FRESHNESS_RATIO = 25;
    double MEDIUM_FRESHNESS_RATIO = 75;
    double LOW_FRESHNESS_RATIO = 100;

    List<Food> getAll();

    boolean add(Food food);

    default double freshnessRatio(Food food) {
        var expiryDays = DAYS.between(food.getExpireDate(), food.getCreateDate());
        var currentDays = DAYS.between(LocalDate.now(), food.getCreateDate());
        return currentDays * 100 / expiryDays;
    }

    void clearStorage();
}
