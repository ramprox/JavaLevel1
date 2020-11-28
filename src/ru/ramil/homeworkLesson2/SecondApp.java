package ru.ramil.homeworkLesson2;

public class SecondApp {
    public static void main(String[] args) {
        invertBitArray();
        initializeIntArrayFrom0To21Step3();
        multiplyOn2IfElementOfArrayLess6();
        createSquareArrayWithUnitDiagonalElements();
        minMaxArray();

        int[] arrForBalance = { 2, 2, 2, 1, 2, 2, 10, 1 };
        printArray(arrForBalance, "Содержимое массива для проверки баланса:");
        System.out.println("Есть ли в массиве место с балансом? " + isExistPlaceWithBalance(arrForBalance));
        arrForBalance = new int[] { 1, 1, 1, 2, 1 };
        printArray(arrForBalance, "Содержимое массива для проверки баланса:");
        System.out.println("Есть ли в массиве место с балансом? " + isExistPlaceWithBalance(arrForBalance));

        int[] arr = { 10, 2, 11, 15, 16 };
        printArray(arr, "Содержимое массива до смещения:");
        int n = -7;
        shiftArray(arr, n);
        printArray(arr, "Содержимое массива после смещения на " + n + " позиций:");
    }

    /* 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
          Например, [1, 1, 0, 0, 1, 0, 1, 1, 0, 0]. С помощью цикла
          и условия заменить 0 на 1, 1 на 0. */
    public static void invertBitArray() {
        int[] bitArray = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };

        printArray(bitArray, "Содержимое массива до инвертирования");

        for(int i = 0; i < bitArray.length; i++) {
            bitArray[i] = bitArray[i] == 0 ? 1 : 0;
        }

        printArray(bitArray, "Содержимое массива после инвертирования");
    }

    /* 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить
          его значениями 0 3 6 9 12 15 18 21. */
    public static void initializeIntArrayFrom0To21Step3() {
        int[] arr = new int[8];
        for(int i = 1; i < arr.length; i++) {
            arr[i] = i * 3;
        }

        printArray(arr, "Содержимое массива от 0 до 21 с шагом 3");
    }

    /* 3. Задать массив [1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1]. Пройти
          по нему циклом и числа меньшие 6 умножить на 2. */
    public static void multiplyOn2IfElementOfArrayLess6() {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        printArray(arr, "Содержимое массива до умножения на 2");

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 6)
                arr[i] *= 2;
        }

        printArray(arr, "Содержимое массива после проверки и умножения на 2");
    }

    /* 4. Создать квадратный двумерный целочисленный массив (количество строк
          и столбцов одинаковое), и с помощью цикла(-ов) заполнить его
          диагональные элементы единицами. */
    public static void createSquareArrayWithUnitDiagonalElements() {
        int n = 5;
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            arr[i][i] = arr[i][n - 1 - i] = 1;
        }

        printArray(arr, "Содержимое массива с диагональными элементами равными 1");
    }

    /* 5. Задать одномерный массив и найти в нем минимальный и максимальный
          элементы. */
    public static void minMaxArray() {
        int[] arr = {2, 5, -8, 6, -15, 12, 100};
        int min, max;
        min = max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if(min > element)
                min = element;
            if(max < element)
                max = element;
        }

        printArray(arr, "Содержимое массива для поиска максимума и минимума");
        System.out.println("Min = " + min + ", Max = " + max);
    }

    /* 6. Написать метод, в который передается не пустой одномерный
          целочисленный массив, метод должен вернуть true, если
          в массиве есть место, в котором сумма левой и правой части
          массива равны. Примеры checkBalance([2, 2, 2, 1, 2, 2, || 10, 1])
          [1, 1, 1, || 2, 1]. */
    public static boolean isExistPlaceWithBalance(int[] array) {
        if(array.length < 2)
            return false;
        int sumLeft = 0;                           // Сумма элементов с левой стороны массива

        int sumRight = array[0];
        for(int i = 1; i < array.length; i++) {    // Начальное значение суммы элементов
            sumRight += array[i];                  // с правой строны sumRight = сумме
        }                                          // элементов массива

        for(int i = 0; i < array.length - 1; i++) {
            sumLeft += array[i];
            sumRight -= array[i];
            if(sumLeft == sumRight)
                return true;
        }
        return false;
    }

    /* 7. Написать метод, которому на вход подается одномерный массив
          и число n (может быть положительным, или отрицательным), при этом
          метод должен сместить все элементы массива на n позиций.
          Нельзя пользоваться вспомогательными массивами. */
    public static void shiftArray(int[] array, int n) {
        int arrLength = array.length;
        if(arrLength == 0 || n % arrLength == 0)
            return;
        if(n > arrLength || n < -arrLength)
            n %= arrLength;
        int indexDest = 0;                       // Индекс элемента - цели копирования
        int tempSrc = array[0];                  // Переменная для хранения копии источника копирования
        int tempDest;                            // Переменная для хранения копии цели копирования
        for(int i = 0; i < arrLength; i++) {
            indexDest += n;                      //
            if(indexDest >= arrLength) {         //
                indexDest %= arrLength;          // Определение индекса цели копирования
            } else if(indexDest < 0) {           //
                indexDest += arrLength;          //
            }                                    //
            tempDest = array[indexDest];
            array[indexDest] = tempSrc;
            tempSrc = tempDest;
        }
    }

    public static void printArray(int[] array, String header) {
        printHeader(header);
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void printArray(int[][] array, String header) {
        printHeader(header);
        for(int i = 0; i < array.length; i++) {
            printArray(array[i], "");
        }
        System.out.println();
    }

    public static void printHeader(String header) {
        if(header != "") {
            System.out.println(header);
        }
    }
}
