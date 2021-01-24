package ru.ramil.homeworkLesson8;

import java.awt.*;

public class TicTacToeGUI {

    public static void main(String[] args) {
        EventQueue.invokeLater(new MainWindowRunnable());
    }

    public static class MainWindowRunnable implements Runnable {
        @Override
        public void run() {
            new MainWindow();
        }
    }
}
