package com.github.mkotra.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlotMachineTest {

    @Test
    public void testSlotMachine() {
        SlotMachine slotMachine = new SlotMachine(new SlotMachine.DefaultWinStrategy());

        int[] result = slotMachine.play();

        assertNotNull(result, "Slot machine result should not be null");
        assertEquals(3, result.length, "Slot machine should return exactly 3 numbers");
    }

    @Test
    public void testDefaultWinStrategy() {
        SlotMachine.WinStrategy winStrategy = new SlotMachine.DefaultWinStrategy();
        int wins = 0;
        int plays = 1000;

        for (int i = 0; i < plays; i++) {
            if (winStrategy.isWin()) {
                wins++;
            }
        }

        double actualWinRatio = (double) wins / plays;

        System.out.println("Win ratio: " + actualWinRatio);

        assertTrue(actualWinRatio >= 0.05, "Win ratio out of expected bounds: " + actualWinRatio);
        assertTrue(actualWinRatio <= 0.15, "Win ratio out of expected bounds: " + actualWinRatio);
    }
}