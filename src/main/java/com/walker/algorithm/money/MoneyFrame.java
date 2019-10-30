package com.walker.algorithm.money;

import com.walker.algorithm.AlgoVisHelper;

import javax.swing.*;
import java.awt.*;

/**
 * @author walker
 * @date 2019/10/30
 */
public class MoneyFrame extends JFrame {
    private int canvasWidth;
    private int canvasHeight;

    private int[] money;

    public MoneyFrame(String title, int canvasWidth, int canvasHeight) throws HeadlessException {
        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        MoneyFrame.AlgoCanvas canvas = new MoneyFrame.AlgoCanvas();
        setContentPane(canvas);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public MoneyFrame(String title) {
        this(title, 1024, 768);
    }

    public void render(int[] money) {
        this.money = money;
        repaint();
    }

    private class AlgoCanvas extends JPanel {

        public AlgoCanvas() {
            // 双缓存
            super(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            // 抗锯齿
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            // 具体绘制
            AlgoVisHelper.setColor(g2d, AlgoVisHelper.Blue);

            if (money != null) {
                int w = canvasWidth / money.length;
                for (int i = 0; i < money.length; i++) {
                    AlgoVisHelper.fillRectangle(g2d, i * w + 1, canvasHeight - money[i], w - 1, money[i]);
                }
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }
}
