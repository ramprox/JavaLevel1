package ru.ramil.homeworkLesson8.WinArea;

import ru.ramil.homeworkLesson8.Data.GameData;
import java.awt.*;

public class MainDiagonal extends Diagonal {
    @Override
    public boolean isAbleWin(Point turnPoint) {
        return isAbleWinInMainDiagonal(turnPoint);
    }

    @Override
    public void incrementPoint(Point point) {
        point.translate(1, 1);
    }

    @Override
    public Point getStartPoint(Point turnPoint) {
        Point result = new Point(turnPoint);
        int dotsToWin = GameData.DOTS_TO_WIN;
        result.translate(-(dotsToWin - 1), -(dotsToWin - 1));
        if (result.x < 0 || result.y < 0) {
            int maxOutOfBound = Math.max(-result.x, -result.y);
            result.translate(maxOutOfBound, maxOutOfBound);
        }
        return result;
    }

    @Override
    public Point getEndPoint(Point turnPoint) {
        Point result = new Point(turnPoint);
        int dotsToWin = GameData.DOTS_TO_WIN;
        int size = GameData.SIZE;
        result.translate(dotsToWin - 1, dotsToWin - 1);
        if(result.x > size - 1 || result.y > size - 1) {
            int maxOutOfBound = Math.max(result.x - (size - 1), result.y - (size - 1));
            result.translate(-maxOutOfBound, -maxOutOfBound);
        }
        return result;
    }
}
