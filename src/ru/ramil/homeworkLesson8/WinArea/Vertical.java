package ru.ramil.homeworkLesson8.WinArea;

import java.awt.*;

public class Vertical extends Straight {
    @Override
    public void incrementPoint(Point point) {
        point.translate(0, 1);
    }

    @Override
    protected int areaLength(Point startPoint, Point endPoint) {
        return endPoint.y - startPoint.y + 1;
    }

    @Override
    public Point getStartPoint(Point turnPoint) {
        Point result = new Point(turnPoint);
        result.y = getStartIndex(result.y);
        return result;
    }

    @Override
    public Point getEndPoint(Point turnPoint) {
        Point result = new Point(turnPoint);
        result.y = getEndIndex(result.y);
        return result;
    }
}
