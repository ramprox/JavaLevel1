package ru.ramil.homeworkLesson8.AI;

import ru.ramil.homeworkLesson8.Cell;
import ru.ramil.homeworkLesson8.Data.GameData;
import ru.ramil.homeworkLesson8.Players.Player;
import ru.ramil.homeworkLesson8.WinAreaCreators;
import ru.ramil.homeworkLesson8.WinArea.WinAreaDataCreator;

import java.util.Arrays;

public class ScoreCalculator {

    public int getScoreForCell(Cell[][] map, Cell cell, Player own, Player opponent) {
        int result = 0;
        WinAreaDataCreator[] shapers = WinAreaCreators.getShapers();
        for(WinAreaDataCreator shaper : shapers) {
            Cell[] area = shaper.getWinArea(map, cell);
            result += getScoreInArea(area, own, opponent);
        }
        return result;
    }

    private int getScoreInArea(Cell[] area, Player own, Player opponent) {
        int result = 0;
        int subAreaCount = area.length - GameData.DOTS_TO_WIN + 1;
        for(int i = 0; i < subAreaCount; i++) {
            Cell[] subArea = Arrays.copyOfRange(area, i, i + GameData.DOTS_TO_WIN);
            result += getScoreInSubArea(subArea, own, opponent);
        }
        return result;
    }

    private int getScoreInSubArea(Cell[] subArea, Player own, Player opponent) {
        int result = 1;
        char ownSymbol = opponent.getDot();;
        char opponentSymbol = own.getDot();
        for(int i = 0; i < subArea.length; i++) {
            char cellChar = subArea[i].getDot();
            if(cellChar == ownSymbol) {
                result *= 10;
            } else if(cellChar == opponentSymbol) {
                return 0;
            }
        }
        return result;
    }
}
