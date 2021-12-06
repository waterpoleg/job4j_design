package ru.job4j.list;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    private void checkSize() {
        if (container.length == 0) {
            container = Arrays.copyOf(container, 10);
        } else if (size >= container.length) {
            container = Arrays.copyOf(container, size * 2);
        }
    }

    @Override
    public void add(T value) {
        checkSize();
        container[size++] = value;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        var item = get(index);
        container[index] = newValue;
        return item;
    }

    @Override
    public T remove(int index) {
        var item = get(index);
        System.arraycopy(container, index + 1, container, index, size - 1 - index);
        container[size - 1] = null;
        size--;
        modCount++;
        return item;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private int count = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return count < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[count++];
            }
        };
    }
}