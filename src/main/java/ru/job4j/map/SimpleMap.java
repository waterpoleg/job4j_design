package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        var result = true;
        if (count >= LOAD_FACTOR * capacity) {
            expand();
        }
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null) {
            result = false;
        } else {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
        }
        return result;
    }

    private int hash(int hashCode) {
        return (hashCode == 0) ? 0 : hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        capacity *= 2;
        var temp = table;
        table = new MapEntry[capacity];
        for (var map : temp) {
            put(map.key, map.value);
        }
        modCount++;
    }

    @Override
    public V get(K key) {
        var index = indexFor(hash(key.hashCode()));
        return table[index] == null ? null : table[index].value;
    }

    @Override
    public boolean remove(K key) {
        boolean result = true;
        int i = indexFor(hash(key.hashCode()));
        if (table[i] == null || !table[i].key.equals(key)) {
            result = false;
        } else {
            table[i] = null;
            modCount++;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            final MapEntry<K, V>[] oldTable = table;
            final int expectedModCount = modCount;
            private int point = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                int pointNext = point;
                boolean result = false;
                while (pointNext < oldTable.length) {
                    if (oldTable[pointNext++] != null) {
                        result = true;
                        point = pointNext - 1;
                        break;
                    }
                }
                return result;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return oldTable[point++].key;
            }
        };
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
