package com.github.mkotra.algorithms;

import javax.swing.*;
import java.awt.*;

public class Spiral extends Canvas {

    private static final int ALPHA = 2;

    public static void main(String[] args) {
        Spiral canvas = new Spiral();
        JFrame frame = new JFrame(Spiral.class.getSimpleName());
        frame.setLocation(300, 500);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(canvas);
        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        int width = this.getWidth();
        spiral(width - 50, 15, 15);
    }

    private void spiral(int length, int x, int y) {
        Graphics graphics = this.getGraphics();
        if (length > 0) {
            graphics.drawLine(x, y, x + length, y);
            graphics.drawLine(x + length, y, x + length, y + length);
            graphics.drawLine(x + length, y + length, x + ALPHA, y + length);
            graphics.drawLine(x + ALPHA, y + length, x + ALPHA, y + ALPHA);
            spiral(length - 2 * ALPHA, x + ALPHA, y + ALPHA);
        }
    }
}