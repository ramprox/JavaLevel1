package ru.ramil.homeworkLesson8.WinArea;

import ru.ramil.homeworkLesson8.Data.GameData;
import java.awt.*;

abstract class Diagonal extends WinAreaDataCreator {

    protected static boolean isAbleWinInMainDiagonal(Point point) {
        Point transformedPoint = new Point(GameData.SIZE - 1 - point.x, point.y);
        return isAbleWinInSideDiagonal(transformedPoint);
    }

    protected static boolean isAbleWinInSideDiagonal(Point point) {
        int size = GameData.SIZE;
        int dotsToWin = GameData.DOTS_TO_WIN;
        int maxBound, minBound;
        if(size - dotsToWin > 0) {
            maxBound = 2 * size - dotsToWin - 1;
            minBound = dotsToWin - 1;
        }
        else {
            minBound = maxBound = size - 1;
        }
        int rowIndex = point.y;
        int colIndex = point.x;
        return rowIndex + colIndex <= maxBound && rowIndex + colIndex >= minBound;
    }
}
