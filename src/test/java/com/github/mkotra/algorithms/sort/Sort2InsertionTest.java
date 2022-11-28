package com.github.mkotra.algorithms.sort;

import org.junit.jupiter.api.Test;

import static com.github.mkotra.algorithms.sort.Sort.ARRAY;
import static org.assertj.core.api.Assertions.assertThat;

class Sort2InsertionTest {

    @Test
    public void test() {
        Sort2Insertion.show(ARRAY);
        Sort2Insertion.sort(ARRAY);
        assertThat(Sort1Selection.isSorted(ARRAY)).isTrue();
    }
}
