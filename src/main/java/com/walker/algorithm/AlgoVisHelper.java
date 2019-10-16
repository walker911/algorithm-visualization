package com.walker.algorithm;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @author walker
 * @date 2019/10/14
 */
public class AlgoVisHelper {

    private AlgoVisHelper() {
    }

    public static void strokeCircle(Graphics2D g, int x, int y, int r) {

        Ellipse2D circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
        g.draw(circle);
    }

    public static void fillCircle(Graphics2D g, int x, int y, int r) {

        Ellipse2D circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
        g.fill(circle);
    }

    public static void setColor(Graphics2D g, Color color) {
        g.setColor(color);
    }

    public static void setStrokeWidth(Graphics2D g, int w) {
        int strokeWidth = w;
        g.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }

    public static void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("error sleeping");
        }
    }
}
