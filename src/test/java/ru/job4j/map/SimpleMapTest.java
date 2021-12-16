package ru.job4j.map;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenPut() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put(1, 111));
        assertTrue(simpleMap.put(2, 222));
        assertTrue(simpleMap.put(3, 333));
    }

    @Test
    public void whenPutDuplicates() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put(1, 111));
        assertFalse(simpleMap.put(1, 111));
    }

    @Test
    public void whenGet() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        simpleMap.put(1, 111);
        simpleMap.put(2, 222);
        assertThat(simpleMap.get(1), is(111));
    }

    @Test
    public void whenGetNull() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        simpleMap.put(1, 111);
        simpleMap.put(2, 222);
        simpleMap.remove(1);
        assertThat(simpleMap.get(1), is(nullValue()));
    }

    @Test
    public void whenRemoveFirst() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        simpleMap.put(1, 111);
        simpleMap.put(2, 222);
        simpleMap.remove(1);
        assertThat(simpleMap.get(1), is(nullValue()));
    }

    @Test
    public void whenInsertThenDelete() {
        SimpleMap<Integer, Integer> table = new SimpleMap<>();
        table.put(1, 111);
        table.put(3, 333);
        assertThat(table.get(1), is(111));
        assertTrue(table.remove(1));
        assertNull(table.get(1));
    }
}