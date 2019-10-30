package com.walker.algorithm.money;

import com.walker.algorithm.AlgoVisHelper;
import com.walker.algorithm.Circle;

import javax.swing.*;

/**
 * @author walker
 * @date 2019/10/30
 */
public class MoneyVisualizer {
    private int[] money;
    private static int DELAY = 10;
    private MoneyFrame frame;

    public MoneyVisualizer(int sceneWidth, int sceneHeight) {
        money = new int[100];
        for (int i = 0; i < money.length; i++) {
            money[i] = 100;
        }

        SwingUtilities.invokeLater(() -> {
            frame = new MoneyFrame("Money Problem", sceneWidth, sceneHeight);
            new Thread(this::run).start();
        });
    }

    /**
     * 动画逻辑
     */
    private void run() {
        while (true) {
            // 绘制数据
            frame.render(money);
            AlgoVisHelper.pause(DELAY);

            // 更新数据
            for (int i = 0; i < money.length; i++) {
                if (money[i] > 0) {
                    int j = (int) (Math.random() * money.length);
                    money[i] -= 1;
                    money[j] += 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int width = 1000;
        int height = 600;

        MoneyVisualizer vis = new MoneyVisualizer(width, height);
    }
}
