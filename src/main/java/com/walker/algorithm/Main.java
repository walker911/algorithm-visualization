package com.walker.algorithm;

import java.awt.*;

/**
 * @author walker
 * @date 2019/10/14
 */
public class Main {
    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;

        int n = 10;
        Circle[] circles = new Circle[n];
        int r = 50;

        for (int i = 0; i < n; i++) {
            int x = (int) (Math.random() * (sceneWidth - 2 * r)) + r;
            int y = (int) (Math.random() * (sceneHeight - 2 * r)) + r;
            

        }

        EventQueue.invokeLater(() -> {
            AlgoFrame frame = new AlgoFrame("Welcome", 500, 500);
        });
    }
}
