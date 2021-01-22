package ru.ramil.homeworkLesson8.Checkers;

import ru.ramil.homeworkLesson8.*;
import ru.ramil.homeworkLesson8.Data.GameData;
import ru.ramil.homeworkLesson8.Players.*;

public class EndGameChecker {

    private final WinChecker checker = new WinChecker();

    public String check(GameData gameData) {
        if(checker.check(gameData)) {
            Player player = gameData.getCurrentTurnInfo().getPlayer();
            if(player instanceof Human) {
                return "Человек победил!";
            }
            return "Машина победила!";
        }
        if (isMapFull(gameData.getMap())) {
            return "Ничья!";
        }
        return null;
    }

    private boolean isMapFull(Cell[][] map) {
        for (Cell[] row : map) {
            for (Cell cell : row) {
                if (cell.getDot() == GameData.DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
