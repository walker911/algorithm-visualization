package com.walker.algorithm;

import java.awt.*;

/**
 * @author walker
 * @date 2019/10/16
 */
public class AlgoVisualizer {

    /**
     * 数据
     */
    private Circle[] circles;
    /**
     * 视图
     */
    private AlgoFrame frame;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int n) {
        // 初始化数据
        circles = new Circle[n];
        int r = 50;
        for (int i = 0; i < n; i++) {
            int x = (int) (Math.random() * (sceneWidth - 2 * r)) + r;
            int y = (int) (Math.random() * (sceneHeight - 2 * r)) + r;
            int vx = (int) (Math.random() * 11) - 5;
            int vy = (int) (Math.random() * 11) - 5;
            circles[i] = new Circle(x, y, r, vx, vy);
        }

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);

            new Thread(this::run).start();
        });
    }

    /**
     * 动画逻辑
     */
    private void run() {
        while (true) {
            // 绘制数据
            frame.render(circles);
            // AlgoVisHelper.pause(20);

            // 更新数据
            // for (Circle circle : circles) {
            //     circle.move(0, 0, frame.getCanvasWidth(), frame.getCanvasHeight());
            // }
        }
    }
}
