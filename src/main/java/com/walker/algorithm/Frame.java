package com.walker.algorithm;

import javax.swing.*;
import java.awt.*;

/**
 * @author walker
 * @date 2019/10/14
 */
public class Frame {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Welcome");
            frame.setSize(500, 500);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
