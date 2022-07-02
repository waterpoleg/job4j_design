package ru.job4j.ood.lsp.store;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public interface Store {

    List<Food> getAll();

    boolean add(Food food);

    default int freshnessRatio(Food food) {
        var expiryDays = DAYS.between(food.getExpireDate(), food.getCreateDate());
        var currentDays = DAYS.between(LocalDate.now(), food.getCreateDate());
        return (int) (currentDays * 100 / expiryDays);
    }

    void clearStorage();
}
