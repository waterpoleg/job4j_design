package ru.job4j.kiss;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class MaxMinTest extends MaxMin {

    List<Integer> values = List.of(6, -3, -1, 4, 1, 0, 8, 5, 4);

    @Test
    public void testMaxThen8() {
        Assert.assertThat(8, is(max(values, Integer::compareTo)));
    }

    @Test
    public void testMinThenMinus3() {
        Assert.assertThat(-3, is(min(values, Integer::compareTo)));
    }

    @Test
    public void testWhenEmpty() {
        Assert.assertNull(min(Collections.emptyList(), Integer::compareTo));
    }
}
