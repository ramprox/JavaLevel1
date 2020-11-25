package ru.ramil.homeworkLesson1;

public class FirstApp {

    public static void main(String[] args) {
        varsDeclarationAndInitialization();
        System.out.println(function(1, 2, 3, 4));
        System.out.println(sumOfValueIsFrom10To20(10, 5));
        printPositiveOrNegative(5);
        System.out.println(isNegative(10));
        printHelloName("John");
        printIsLeapYear(2020);
    }

    public static void varsDeclarationAndInitialization() {
        byte b = 10;
        short s = 20;
        int i = 30;
        long v = 40L;
        char ch = 'x';
        boolean bool = true;
        float f = 2.5f;
        double d = 50.5;
        String str = "Hello, world!";
    }

    public static float function(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    public static boolean sumOfValueIsFrom10To20(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void printPositiveOrNegative(int a) {
        if(a >= 0) {
            System.out.println("Число " + a + " является положительным.");
        } else {
            System.out.println("Число " + a + " является отрицательным.");
        }
    }

    public static boolean isNegative(int a) {
        return a < 0;
    }

    public static void printHelloName(String name) {
        System.out.println("Привет, " + name);
    }

    public static void printIsLeapYear(int year) {
        String result = year < 1 ? -year + 1 + " г. до н.э." : year + " г."; // Принимаем, что 0 г. соответствует 1 г. до н.э.
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            System.out.println(result + " является високосным");
        } else {
            System.out.println(result + " является невисокосным");
        }
    }
}