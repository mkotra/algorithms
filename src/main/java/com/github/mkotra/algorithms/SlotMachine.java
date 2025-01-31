package com.github.mkotra.algorithms;

import java.util.Random;

public class SlotMachine {

    private static final int SLOT_RANGE = 10; // Range of slot numbers (0-9)
    private final WinStrategy winStrategy;
    private final Random random;

    SlotMachine(WinStrategy winStrategy) {
        this.winStrategy = winStrategy;
        this.random = new Random();
    }

    public int[] play() {
        if (winStrategy.isWin()) {
            int winNumber = random.nextInt(SLOT_RANGE);
            return new int[]{winNumber, winNumber, winNumber};
        } else {
            return new int[]{random.nextInt(SLOT_RANGE), random.nextInt(SLOT_RANGE), random.nextInt(SLOT_RANGE)};
        }
    }

    interface WinStrategy {
        boolean isWin();
    }

    public static class DefaultWinStrategy implements WinStrategy {
        private static final double WIN_RATIO = 0.10;
        private final Random random = new Random();

        @Override
        public boolean isWin() {
            return random.nextDouble() < WIN_RATIO;
        }
    }
}
