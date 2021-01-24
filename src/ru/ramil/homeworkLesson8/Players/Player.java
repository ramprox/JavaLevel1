package ru.ramil.homeworkLesson8.Players;

public abstract class Player {
    private final char dot;

    public Player(char dot) {
        this.dot = dot;
    }

    public char getDot() {
        return dot;
    }
}
