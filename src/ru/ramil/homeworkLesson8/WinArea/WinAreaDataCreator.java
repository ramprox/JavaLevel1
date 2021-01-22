package ru.ramil.homeworkLesson8.WinArea;

import ru.ramil.homeworkLesson8.Cell;

import java.awt.*;

public abstract class WinAreaDataCreator {

    protected abstract Point getStartPoint(Point turnPoint);
    protected abstract Point getEndPoint(Point turnPoint);
    protected abstract void incrementPoint(Point point);

    protected int areaLength(Point startPoint, Point endPoint) {
        return endPoint.x - startPoint.x + 1;
    }

    protected boolean isAbleWin(Point turnPoint) {
        return true;
    }

    protected Point getTurnPoint(Cell[][] map, Cell cellTurn) {
        Point result = new Point(-1, -1);
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++){
                Cell cell = map[i][j];
                if(cell == cellTurn) {
                    result.x = j;
                    result.y = i;
                }
            }
        }
        return result;
    }

    public Cell[] getWinArea(Cell[][] map, Cell cell) {
        Point turnPoint = getTurnPoint(map, cell);
        if(!isAbleWin(turnPoint)) {
            return new Cell[0];
        }
        Point startPoint = getStartPoint(turnPoint);
        Point endPoint = getEndPoint(turnPoint);
        int areaLength = areaLength(startPoint, endPoint);
        Cell[] result = new Cell[areaLength];
        int i = 0;
        while(i < areaLength) {
            result[i] = map[startPoint.y][startPoint.x];
            incrementPoint(startPoint);
            i++;
        }
        return result;
    }
}
