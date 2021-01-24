package ru.ramil.homeworkLesson8.WinArea;

import ru.ramil.homeworkLesson8.Data.GameData;

abstract class Straight extends WinAreaDataCreator {

    protected static int getStartIndex(int index) {
        int result = index - (GameData.DOTS_TO_WIN - 1);
        if(result < 0)
            result = 0;
        return result;
    }

    protected static int getEndIndex(int index) {
        int result = index + GameData.DOTS_TO_WIN - 1;
        if(result >= GameData.SIZE)
            result = GameData.SIZE - 1;
        return result;
    }
}
