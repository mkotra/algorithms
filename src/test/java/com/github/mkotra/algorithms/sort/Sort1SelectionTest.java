package com.github.mkotra.algorithms.sort;

import org.junit.jupiter.api.Test;

import static com.github.mkotra.algorithms.sort.Sort.ARRAY;
import static org.assertj.core.api.Assertions.assertThat;

class Sort1SelectionTest {

    @Test
    public void test() {
        Sort1Selection.show(ARRAY);
        Sort1Selection.sort(ARRAY);
        assertThat(Sort1Selection.isSorted(ARRAY)).isTrue();
    }
}
