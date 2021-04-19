package com.github.mkotra.algorithms.sort;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.github.mkotra.algorithms.sort.Sort.ARRAY;

class Sort1SelectionTest {

    @Test
    public void test() {
        Sort1Selection.show(ARRAY);
        Sort1Selection.sort(ARRAY);
        Assertions.assertThat(Sort1Selection.isSorted(ARRAY)).isTrue();
    }
}
