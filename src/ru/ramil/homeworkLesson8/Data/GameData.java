package ru.ramil.homeworkLesson8.Data;

import ru.ramil.homeworkLesson8.Cell;
import ru.ramil.homeworkLesson8.Players.Player;

public class GameData {
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    private final Cell[][] map = new Cell[SIZE][SIZE];
    private final CurrentTurnInfo currentTurnInfo = new CurrentTurnInfo();
    private boolean isEndGame;

    public Cell[][] getMap() {
        return map;
    }

    public void setCurrentTurnInfo(Player player, Cell turnCell) {
        currentTurnInfo.setPlayer(player);
        currentTurnInfo.setCellTurn(turnCell);
    }

    public CurrentTurnInfo getCurrentTurnInfo() {
        return currentTurnInfo;
    }

    public void setEndGame(boolean value) {
        isEndGame = value;
    }

    public boolean getEndGame() {
        return isEndGame;
    }

    public GameData() {
        initializeMap();
    }

    public void initializeMap() {
        for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
            for (int colIndex = 0; colIndex < SIZE; colIndex++) {
                map[rowIndex][colIndex] = new Cell(DOT_EMPTY);
            }
        }
    }

    public void resetGame() {
        isEndGame = false;
        for(Cell[] rowCells : map) {
            for(Cell cell : rowCells) {
                cell.setDot(DOT_EMPTY);
                cell.setEnabled(true);
            }
        }
        setCurrentTurnInfo(null, null);
    }
}
