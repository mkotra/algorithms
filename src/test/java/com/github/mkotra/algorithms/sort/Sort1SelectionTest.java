package com.github.mkotra.algorithms.sort;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Sort1SelectionTest {

    @Test
    public void test() {
        Integer[] array = new Integer[] {5, 3, 8, 0, 2, 4, 6, 7, 9, 1};
        Sort1Selection.sort(array);
        Assertions.assertThat(Sort1Selection.isSorted(array)).isTrue();
    }
}