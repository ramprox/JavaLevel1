package ru.ramil.homeworkLesson8;

import ru.ramil.homeworkLesson8.Checkers.EndGameChecker;
import ru.ramil.homeworkLesson8.Data.GameData;
import ru.ramil.homeworkLesson8.Players.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private static final Computer computer = new Computer(GameData.DOT_O);
    private static final Human human = new Human(GameData.DOT_X);
    private static final EndGameChecker endGameChecker = new EndGameChecker();
    private static final GameData gameData = new GameData();

    public MainWindow() {
        setTitle("TicTacToe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(GameData.SIZE, GameData.SIZE));
        addMenu();
        addCells();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Game");
        JMenuItem menuItem = new JMenuItem("New");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameData.resetGame();
            }
        });
        menu.add(menuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void addCells() {
        ClickListener listener = new ClickListener();
        Cell[][] map = gameData.getMap();
        for(Cell[] rowCells : map ) {
            for(Cell cell : rowCells) {
                cell.addActionListener(listener);
                add(cell);
            }
        }
    }

    private void computerTurn() {
        if(!gameData.getEndGame()) {
            Cell cellTurn = computer.turn(gameData.getMap(), human);
            setTurnInfoAndCheck(computer, cellTurn);
        }
    }

    private void setTurnInfoAndCheck(Player player, Cell cellTurn) {
        cellTurn.setDot(player.getDot());
        gameData.setCurrentTurnInfo(player, cellTurn);
        String result = endGameChecker.check(gameData);
        if(result != null) {
            gameData.setEndGame(true);
            for(Cell[] rowCells : gameData.getMap()) {
                for(Cell cell : rowCells) {
                    cell.setEnabled(false);
                }
            }
            JOptionPane.showConfirmDialog(getParent(), result, "Игра окончена", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class ClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Cell cellTurn = (Cell)e.getSource();
            setTurnInfoAndCheck(human, cellTurn);
            computerTurn();
        }
    }
}
