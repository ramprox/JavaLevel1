package ru.ramil.homeworkLesson8.Players;

import ru.ramil.homeworkLesson8.AI.ArtificialIntelligence;
import ru.ramil.homeworkLesson8.Cell;

public class Computer extends Player {

    private final ArtificialIntelligence ai = new ArtificialIntelligence();

    public Computer(char dot) {
        super(dot);
    }

    public Cell turn(Cell[][] map, Player opponent) {
        return ai.getBestCell(map, this, opponent);
    }
}
