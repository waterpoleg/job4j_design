package ru.job4j.set;

import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(10);

    @Override
    public boolean add(T value) {
        var result = !contains(value);
        if (result) {
            set.add(value);
        }
        return result;
    }

    @Override
    public boolean contains(T value) {
        var result = false;
        for (var s : set) {
            if (Objects.equals(s, value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
