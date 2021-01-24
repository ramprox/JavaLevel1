package ru.ramil.homeworkLesson8.WinArea;

import java.awt.*;

public class Horizontal extends Straight {
    @Override
    public void incrementPoint(Point point) {
        point.translate(1, 0);
    }

    @Override
    public Point getStartPoint(Point turnPoint) {
        Point result = new Point(turnPoint);
        result.x = getStartIndex(result.x);
        return result;
    }

    @Override
    public Point getEndPoint(Point turnPoint) {
        Point result = new Point(turnPoint);
        result.x = getEndIndex(result.x);
        return result;
    }
}
