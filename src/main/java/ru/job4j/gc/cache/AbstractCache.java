package ru.job4j.gc.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<V, K> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public V get(K key) {
        V v = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (v == null) {
            v = load(key);
            put(key, v);
        }
        return v;
    }

    protected abstract V load(K key);
}
