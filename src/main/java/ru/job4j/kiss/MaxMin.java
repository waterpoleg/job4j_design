package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findBy(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findBy(value, comparator.reversed());
    }

    private <T> T findBy(List<T> values, Comparator<T> comparator) {
        if (values == null || values.isEmpty()) {
            return null;
        }
        T rsl = values.get(0);
        for (T value : values) {
            rsl = comparator.compare(rsl, value) >= 0 ? rsl : value;
        }
        return rsl;
    }
}
