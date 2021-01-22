package ru.ramil.homeworkLesson8.AI;

import ru.ramil.homeworkLesson8.Cell;
import ru.ramil.homeworkLesson8.Data.GameData;
import ru.ramil.homeworkLesson8.Players.Player;

public class ArtificialIntelligence {

    private final ScoreCalculator calculator = new ScoreCalculator();

    public Cell getBestCell(Cell[][] map, Player own, Player opponent) {
        Cell result = null;
        int maxScoreForOpponent = 0;
        for(Cell[] rowCells : map) {
            for(Cell cell : rowCells) {
                if(cell.getDot() != GameData.DOT_EMPTY)
                    continue;
                int score = calculator.getScoreForCell(map, cell, own, opponent);
                if(score > maxScoreForOpponent) {
                    maxScoreForOpponent = score;
                    result = cell;
                } else if(maxScoreForOpponent == 0) {
                    result = cell;
                }
            }
        }
        return result;
    }
}
