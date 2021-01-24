package ru.ramil.homeworkLesson8;

import ru.ramil.homeworkLesson8.Data.GameData;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {

    private static final int DEFAULT_SIZE = 100;
    private char dot;

    public char getDot() {
        return dot;
    }

    public void setDot(char value) {
        dot = value;
        repaint();
    }

    public Cell(char dot) {
        this.dot = dot;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_SIZE, DEFAULT_SIZE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D)g;
        g2D.setStroke(new BasicStroke(5));
        g2D.setColor(Color.RED);
        if(dot == GameData.DOT_O) {
            g2D.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
        } else if(dot == GameData.DOT_X) {
            g2D.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
            g2D.drawLine(10, getHeight() - 10, getWidth() - 10, 10);
        }
    }
}
