package ru.ramil.homeworkLesson4;

import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 5;
    private static final int DOTS_TO_WIN = 4;                         // Количество фишек для победы
    private static final char[][] map = new char[SIZE][SIZE];

    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    public static final Scanner SCANNER = new Scanner(System.in);

    private static int rowIndexTurn = -1;       // Поля для сохранения текущих координат хода машины и человека
    private static int colIndexTurn = -1;       // для последующей проверки победы, что позволит не перебирать
                                                // все возможные проверки в цикле по всему полю, а проверить победу
                                                // только для вновь введенных координат

    public static void main(String[] args) {
        initializeGame();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkEndGame(DOT_X)) {
                break;
            }

            computerTurn();
            printMap();
            if (checkEndGame(DOT_O)) {
                break;
            }
        }
    }

    private static void initializeGame() {
        for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
            for (int colIndex = 0; colIndex < SIZE; colIndex++) {
                map[rowIndex][colIndex] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printHeader();
        printMapState();
        System.out.println();
    }

    private static void printMapState() {
        for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
            System.out.print((rowIndex + 1) + " ");

            for (int colIndex = 0; colIndex < SIZE; colIndex++) {
                System.out.print(map[rowIndex][colIndex] + " ");
            }

            System.out.println();
        }
    }

    private static void printHeader() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static boolean checkEndGame(char symbol) {
        if (checkWin(symbol)) {
            System.out.println(isHumanTurn(symbol) ? "Человек победил!" : "Машина победила!");
            return true;
        }
        if (isMapFull()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    private static boolean isMapFull() {
        for (char[] row : map) {
            for (char cellValue : row) {
                if (cellValue == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isCellValid(int rowIndex, int colIndex, char symbol) {
        if (!isArrayIndexValid(rowIndex) || !isArrayIndexValid(colIndex)) {
            System.out.println("Индексы строки и колонки должны быть в диапазоне от 0 до " + SIZE);
            return false;
        }
        if (map[rowIndex][colIndex] != DOT_EMPTY) {
            if (isHumanTurn(symbol)) {
                System.out.println("Данная ячейка уже занята!");
            }
            return false;
        }
        return true;
    }

    private static boolean isArrayIndexValid(int index) {
        return index >= 0 && index < SIZE;
    }

    private static boolean isHumanTurn(char symbol) {
        return symbol == DOT_X;
    }

    private static void humanTurn() {
        int rowIndex = -1;
        int colIndex = -1;
        do {
            System.out.print("Введите номер строки: ");
            if (!SCANNER.hasNextInt()) {
                SCANNER.nextLine();
                System.out.println("Введите число!");
                continue;
            }
            rowIndex = SCANNER.nextInt() - 1;

            System.out.print("Введите номер столбца: ");
            if (!SCANNER.hasNextInt()) {
                SCANNER.nextLine();
                System.out.println("Введите число!");
                continue;
            }
            colIndex = SCANNER.nextInt() - 1;
        } while (!isCellValid(rowIndex, colIndex, DOT_X));

        rowIndexTurn = rowIndex;
        colIndexTurn = colIndex;
        map[rowIndexTurn][colIndexTurn] = DOT_X;
    }

    private static boolean checkWin(char symbol) {
        if(checkWinHorizontal(symbol)) {
            return true;
        }
        if(checkWinVertical(symbol)) {
            return true;
        }
        if(checkWinMainDiagonal(symbol)) {
            return true;
        }
        if(checkWinSideDiagonal(symbol)) {
            return true;
        }
        return false;
    }

    // Проверка победы для точки по горизонтали
    private static boolean checkWinHorizontal(char symbol) {
        int startColIndex = getStartIndex(colIndexTurn);
        int endColIndex = getEndIndex(colIndexTurn);
        for(int colIndex = startColIndex; colIndex <= endColIndex; colIndex++) {
            if(checkWinHorizontalForSample(colIndex, symbol))
                return true;
        }
        return false;
    }

    // Проверка победы для отдельной выборки по горизонтали
    private static boolean checkWinHorizontalForSample(int startIndex, char symbol) {
        int endIndex = startIndex + DOTS_TO_WIN;
        for(int colIndex = startIndex; colIndex < endIndex; colIndex++) {
            if(map[rowIndexTurn][colIndex] != symbol) {
                return false;
            }
        }
        return true;
    }

    // Проверка победы для точки по вертикали
    private static boolean checkWinVertical(char symbol) {
        int startRowIndex = getStartIndex(rowIndexTurn);
        int endRowIndex = getEndIndex(rowIndexTurn);
        for(int rowIndex = startRowIndex; rowIndex <= endRowIndex; rowIndex++) {
            if(checkWinVerticalForSample(rowIndex, symbol)) {
                return true;
            }
        }
        return false;
    }

    // Проверка победы для отдельной выборки по вертикали
    private static boolean checkWinVerticalForSample(int startIndex, char symbol) {
        int endIndex = startIndex + DOTS_TO_WIN;
        for(int rowIndex = startIndex; rowIndex < endIndex; rowIndex++) {
            if(map[rowIndex][colIndexTurn] != symbol) {
                return false;
            }
        }
        return true;
    }

    // Начальный индекс для горизонтальных и вертикальных проверок
    private static int getStartIndex(int index) {
        int result = index - (DOTS_TO_WIN - 1);
        if(result < 0)
            result = 0;
        return result;
    }

    //Конечный индекс для горизонтальных и вертикальных проверок
    private static int getEndIndex(int index) {
        int result = index;
        if(result > SIZE - DOTS_TO_WIN)
            result -= result - (SIZE - DOTS_TO_WIN);
        return result;
    }

    // Проверка победы для точки по главной диагонали
    public static boolean checkWinMainDiagonal(char symbol) {
        if(isAbleWinInMainDiagonal(rowIndexTurn, colIndexTurn)) {
            int[] startIndexes = getStartIndexes(rowIndexTurn, colIndexTurn, true);
            int startRowIndex = startIndexes[0];
            int startColIndex = startIndexes[1];
            int endColIndex = getEndColIndex(rowIndexTurn, colIndexTurn, true);
            int iterationCount = endColIndex - startColIndex + 1;
            for(int i = 0; i < iterationCount; i++) {
                if(checkWinMainDiagonalForSample(startRowIndex, startColIndex, symbol)) {
                    return true;
                }
                startRowIndex++;
                startColIndex++;
            }
        }
        return false;
    }

    // Проверка победы для отдельной выборки по главной диагонали
    public static boolean checkWinMainDiagonalForSample(int rowIndex, int colIndex, char symbol) {
        for(int i = 0; i < DOTS_TO_WIN; i++) {
            if(map[rowIndex][colIndex] != symbol) {
                return false;
            }
            rowIndex++;
            colIndex++;
        }
        return true;
    }

    // Проверка победы для точки по побочной диагонали
    public static boolean checkWinSideDiagonal(char symbol) {
        if(isAbleWinInSideDiagonal(rowIndexTurn, colIndexTurn)) {
            int[] startIndexes = getStartIndexes(rowIndexTurn, colIndexTurn, false);
            int startRowIndex = startIndexes[0];
            int startColIndex = startIndexes[1];

            int endColIndex = getEndColIndex(rowIndexTurn, colIndexTurn, false);
            int iterationCount = endColIndex - startColIndex + 1;

            for(int i = 0; i < iterationCount; i++) {
                if(checkWinSideDiagonalForSample(startRowIndex, startColIndex, symbol)) {
                    return true;
                }
                startRowIndex--;
                startColIndex++;
            }
        }
        return false;
    }

    // Проверка победы для отдельной выборки по побочной диагонали
    public static boolean checkWinSideDiagonalForSample(int rowIndex, int colIndex, char symbol) {
        for(int i = 0; i < DOTS_TO_WIN; i++) {
            if(map[rowIndex][colIndex] != symbol)
                return false;
            rowIndex--;
            colIndex++;
        }
        return true;
    }

    // Вычисление стартовых индексов для точки по диагоналям
    private static int[] getStartIndexes(int rowIndex, int colIndex, boolean mainDiagonal) {
        int[] result = new int[2];
        int startRowIndex;
        int startColIndex;
        if(mainDiagonal) {
            startRowIndex = rowIndex - (DOTS_TO_WIN - 1);
            startColIndex = colIndex - (DOTS_TO_WIN - 1);
            if (startColIndex < 0 || startRowIndex < 0) {
                int minRowCol = Math.min(startColIndex, startRowIndex);
                startRowIndex -= minRowCol;
                startColIndex -= minRowCol;
            }
        } else {
            startRowIndex = rowIndex + (DOTS_TO_WIN - 1);
            startColIndex = colIndex - (DOTS_TO_WIN - 1);
            if(startColIndex < 0 || startRowIndex > SIZE - 1) {
                int minRowCol = Math.min(startColIndex, SIZE - 1 - startRowIndex);
                startRowIndex += minRowCol;
                startColIndex -= minRowCol;
            }
        }
        result[0] = startRowIndex;
        result[1] = startColIndex;
        return result;
    }

    // Вычиcление конечного индекса колонки для диагоналей
    private static int getEndColIndex(int rowIndex, int colIndex, boolean mainDiagonal) {
        int result = colIndex;
        if(mainDiagonal) {
            if (rowIndex > SIZE - DOTS_TO_WIN || result > SIZE - DOTS_TO_WIN) {
                int diffRow = rowIndex - (SIZE - DOTS_TO_WIN);
                int diffCol = result - (SIZE - DOTS_TO_WIN);
                int maxDiff = Math.max(diffRow, diffCol);
                result -= maxDiff;
            }
        } else {
            if(rowIndex < DOTS_TO_WIN - 1 || result > SIZE - DOTS_TO_WIN) {
                int diffRow = DOTS_TO_WIN - 1 - rowIndex;
                int diffCol = result - (SIZE - DOTS_TO_WIN);
                int maxDiff = Math.max(diffCol, diffRow);
                result -= maxDiff;
            }
        }
        return result;
    }

    // Возможна ли победа для точки по главной диагонали
    public static boolean isAbleWinInMainDiagonal(int rowIndex, int colIndex) {
        return isAbleWinInSideDiagonal(rowIndex, SIZE - 1 - colIndex);
    }

    // Возможна ли победа для точки по побочной диагонали
    public static boolean isAbleWinInSideDiagonal(int rowIndex, int colIndex) {
        int maxBound, minBound;
        if(SIZE - DOTS_TO_WIN > 0) {
            maxBound = 2 * SIZE - DOTS_TO_WIN - 1;
            minBound = DOTS_TO_WIN - 1;
        }
        else {
            minBound = maxBound = SIZE - 1;
        }
        return rowIndex + colIndex <= maxBound && rowIndex + colIndex >= minBound;
    }

    private static void computerTurn() {
        int rowIndex = -1;
        int colIndex = -1;
        int maxScoreForDotX = 0;
        for(int row = 0; row < SIZE; row++) {
            for(int col = 0; col < SIZE; col++) {
                if(map[row][col] != DOT_EMPTY)
                    continue;
                int score = getScoreForPoint(row, col, DOT_X);
                if(score > maxScoreForDotX) {                    //
                    maxScoreForDotX = score;                     // Поиск координат, в которые если поставит
                    rowIndex = row;                              // противник получит наибольшее количество очков
                    colIndex = col;                              //
                } else if(maxScoreForDotX == 0) {                // если таких координат нет,
                    rowIndex = row;                              // то запомним последние
                    colIndex = col;                              // валидные координаты
                }
            }
        }

        rowIndexTurn = rowIndex;
        colIndexTurn = colIndex;
        map[rowIndexTurn][colIndexTurn] = DOT_O;
    }

    // Получить очки для противника при условии, что он поставил на передаваемые индексы
    private static int getScoreForPoint(int rowIndex, int colIndex, char symbol) {
        int result = 0;
        result += getHorizontalScoreForPoint(rowIndex, colIndex, symbol);
        result += getVerticalScoreForPoint(rowIndex, colIndex, symbol);
        if(isAbleWinInMainDiagonal(rowIndex, colIndex)) {
            result += getMainDiagonalScoreForPoint(rowIndex, colIndex, symbol);
        }
        if(isAbleWinInSideDiagonal(rowIndex, colIndex)) {
            result += getSideDiagonalScoreForPoint(rowIndex, colIndex, symbol);
        }
        return result;
    }

    // Получить очки для противника по горизонтали
    private static int getHorizontalScoreForPoint(int rowIndex, int colIndex, char symbol) {
        int result = 0;
        int startColIndex = getStartIndex(colIndex);
        int endColIndex = getEndIndex(colIndex);
        for(int i = startColIndex; i <= endColIndex; i++) {
            result += getHorizontalScoreForSample(rowIndex, i, DOT_X);
        }
        return result;
    }

    // Получить очки для противника по горизонтали для отдельной выборки
    private static int getHorizontalScoreForSample(int rowIndex, int startColIndex, char symbol) {
        int result = 1;
        char opponentSymbol = symbol == DOT_X ? DOT_O : DOT_X;
        int endColIndex = startColIndex + DOTS_TO_WIN;
        for(int colIndex = startColIndex; colIndex < endColIndex; colIndex++) {
            if(map[rowIndex][colIndex] == opponentSymbol) {
                return 0;
            } else if(map[rowIndex][colIndex] == symbol) {
                result *= 10;
            }
        }
        return result;
    }

    // Получить очки для противника по вертикали
    private static int getVerticalScoreForPoint(int rowIndex, int colIndex, char symbol) {
        int result = 0;
        int startRowIndex = getStartIndex(rowIndex);
        int endRowIndex = getEndIndex(rowIndex);
        for(int i = startRowIndex; i <= endRowIndex; i++) {
            result += getVerticalScoreForSample(i, colIndex, symbol);
        }
        return result;
    }

    // Получить очки для противника по вертикали для отдельной выборки
    private static int getVerticalScoreForSample(int startRowIndex, int colIndex, char symbol) {
        int result = 1;
        char opponentSymbol = symbol == DOT_X ? DOT_O : DOT_X;
        int endIndex = startRowIndex + DOTS_TO_WIN;
        for(int rowIndex = startRowIndex; rowIndex < endIndex; rowIndex++) {
            if(map[rowIndex][colIndex] == opponentSymbol) {
                return 0;
            } else if(map[rowIndex][colIndex] == symbol) {
                result *= 10;
            }
        }
        return result;
    }

    // Получить очки для противника по главной диагонали
    private static int getMainDiagonalScoreForPoint(int rowIndex, int colIndex, char symbol) {
        int result = 0;
        int[] startIndexes = getStartIndexes(rowIndex, colIndex, true);
        int startRowIndex = startIndexes[0];
        int startColIndex = startIndexes[1];
        int endColIndex = getEndColIndex(rowIndex, colIndex, true);
        int iterationCount = endColIndex - startColIndex + 1;
        for(int i = 0; i < iterationCount; i++) {
            result += getMainDiagonalScoreForSample(startRowIndex, startColIndex, symbol);
            startRowIndex++;
            startColIndex++;
        }
        return result;
    }

    // Получить очки для противника по главной диагонали для отдельной выборки
    private static int getMainDiagonalScoreForSample(int rowIndex, int colIndex, char symbol) {
        int result = 1;
        char opponentSymbol = symbol == DOT_X ? DOT_O : DOT_X;
        for(int i = 0; i < DOTS_TO_WIN; i++) {
            if(map[rowIndex][colIndex] == opponentSymbol) {
                return 0;
            } else if(map[rowIndex][colIndex] == symbol) {
                result *= 10;
            }
            rowIndex++;
            colIndex++;
        }
        return result;
    }

    // Получить очки для противника по побочной диагонали
    private static int getSideDiagonalScoreForPoint(int rowIndex, int colIndex, char symbol) {
        int result = 0;
        int[] startIndexes = getStartIndexes(rowIndex, colIndex, false);
        int startRowIndex = startIndexes[0];
        int startColIndex = startIndexes[1];
        int endColIndex = getEndColIndex(rowIndex, colIndex, false);
        int iterationCount = endColIndex - startColIndex + 1;
        for(int i = 0; i < iterationCount; i++) {
            result += getSideDiagonalScoreForSample(startRowIndex, startColIndex, symbol);
            startRowIndex--;
            startColIndex++;
        }
        return result;
    }

    // Получить очки для противника по побочной диагонали для отдельной выборки
    private static int getSideDiagonalScoreForSample(int rowIndex, int colIndex, char symbol) {
        int result = 1;
        char opponentSymbol = symbol == DOT_X ? DOT_O : DOT_X;
        for(int i = 0; i < DOTS_TO_WIN; i++) {
            if(map[rowIndex][colIndex] == opponentSymbol) {
                return 0;
            } else if(map[rowIndex][colIndex] == symbol) {
                result *= 10;
            }
            rowIndex--;
            colIndex++;
        }
        return result;
    }
}
