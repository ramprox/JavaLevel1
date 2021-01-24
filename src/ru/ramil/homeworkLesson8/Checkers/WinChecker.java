package ru.ramil.homeworkLesson8.Checkers;

import ru.ramil.homeworkLesson8.Cell;
import ru.ramil.homeworkLesson8.Data.*;
import ru.ramil.homeworkLesson8.Players.Player;
import ru.ramil.homeworkLesson8.WinAreaCreators;
import ru.ramil.homeworkLesson8.WinArea.WinAreaDataCreator;

public class WinChecker {

    public boolean check(GameData gameData) {
        WinAreaDataCreator[] shapers = WinAreaCreators.getShapers();
        Cell[][] map = gameData.getMap();
        CurrentTurnInfo turnInfo = gameData.getCurrentTurnInfo();
        Cell turnCell = turnInfo.getCellTurn();
        Player player = turnInfo.getPlayer();
        for(WinAreaDataCreator shaper : shapers) {
            Cell[] area = shaper.getWinArea(map, turnCell);
            if(checkWinInArea(area, player)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWinInArea(Cell[] area, Player player) {
        int count = 0;
        for (Cell cell : area) {
            count = cell.getDot() == player.getDot() ? count + 1 : 0;
            if (count == GameData.DOTS_TO_WIN) {
                return true;
            }
        }
        return false;
    }
}
