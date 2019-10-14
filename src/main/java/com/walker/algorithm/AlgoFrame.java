package com.walker.algorithm;

import javax.swing.*;
import java.awt.*;

/**
 * @author walker
 * @date 2019/10/14
 */
public class AlgoFrame extends JFrame {

    private int canvasWidth;
    private int canvasHeight;

    private Circle[] circles;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) throws HeadlessException {
        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        // setSize(canvasWidth, canvasHeight);
        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public AlgoFrame(String title) {
        this(title, 1024, 768);
    }

    public void render(Circle[] circles) {
        this.circles = circles;
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
            // AlgoVisHelper.setStrokeWidth(g2d, 5);

            // AlgoVisHelper.setColor(g2d, Color.RED);
            // AlgoVisHelper.strokeCircle(g2d, canvasWidth / 2, canvasHeight / 2, 200);
            //
            // AlgoVisHelper.setColor(g2d, Color.BLUE);
            // AlgoVisHelper.fillCircle(g2d, canvasWidth / 2, canvasHeight / 2, 200);

            AlgoVisHelper.setStrokeWidth(g2d, 1);
            AlgoVisHelper.setColor(g2d, Color.RED);
            for (Circle circle : circles) {
                AlgoVisHelper.strokeCircle(g2d, circle.x, circle.y, circle.getR());
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

    public void setCanvasWidth(int canvasWidth) {
        this.canvasWidth = canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    public void setCanvasHeight(int canvasHeight) {
        this.canvasHeight = canvasHeight;
    }
}