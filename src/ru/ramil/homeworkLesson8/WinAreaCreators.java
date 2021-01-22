package ru.ramil.homeworkLesson8;

import ru.ramil.homeworkLesson8.WinArea.*;

public class WinAreaCreators {

    private static final WinAreaDataCreator[] shapers = new WinAreaDataCreator[4];

    static {
        shapers[0] = new Horizontal();
        shapers[1] = new Vertical();
        shapers[2] = new MainDiagonal();
        shapers[3] = new SideDiagonal();
    }

    public static WinAreaDataCreator[] getShapers () {
        return shapers;
    }
}
