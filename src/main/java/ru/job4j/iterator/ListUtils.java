package ru.job4j.iterator;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> listIterator = list.listIterator(index);
        listIterator.add(value);
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        var listIterator = list.listIterator(index + 1);
        listIterator.add(value);
    }

    public static <T> List<T> removeIf(List<T> list, Predicate<T> filter) {
        var listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (filter.test(listIterator.next())) {
                listIterator.remove();
            }
        }
        return list;
    }

    public static <T> List<T> replaceIf(List<T> list, Predicate<T> filter, T value) {
        var listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (filter.test(listIterator.next())) {
                listIterator.set(value);
            }
        }
        return list;
    }

    public static <T> List<T> removeAll(List<T> list, List<T> elements) {
        var listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (elements.contains(listIterator.next())) {
                listIterator.remove();
            }
        }
        return list;
    }
}
