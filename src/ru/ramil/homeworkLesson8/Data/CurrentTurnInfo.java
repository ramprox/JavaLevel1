package ru.ramil.homeworkLesson8.Data;

import ru.ramil.homeworkLesson8.Cell;
import ru.ramil.homeworkLesson8.Players.Player;

public class CurrentTurnInfo {
    private Player player;
    private Cell cellTurn;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCellTurn(Cell cellTurn) {
        this.cellTurn = cellTurn;
    }

    public Cell getCellTurn() {
        return cellTurn;
    }
}
