package com.github.mkotra.algorithms;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.catchThrowableOfType;

class ChangeTest {

    @Test
    public void shouldThrowExceptionWhenNotEnoughMoney() {
        IllegalStateException exception = catchThrowableOfType(() -> {
            Change.change(150, 100);
        }, IllegalStateException.class);

        Assertions.assertThat(exception).isNotNull();
        Assertions.assertThat(exception.getMessage()).isEqualTo("Not enough money -50");
    }

    @Test
    public void shouldThrowExceptionWhenNotEnoughCoins() {
        IllegalStateException exception = catchThrowableOfType(() -> {
            Change.change(0, 10000);
        }, IllegalStateException.class);

        Assertions.assertThat(exception).isNotNull();
        Assertions.assertThat(exception.getMessage()).contains("Cannot handle, there is not enough coins -5921");
    }

    @Test
    public void shouldReturnValidChange() {
        List<Integer> expected = Arrays.asList(10, 5, 2);
        List<Integer> result = Change.change(133, 150);
        Assertions.assertThat(result).isEqualTo(expected);
    }

}