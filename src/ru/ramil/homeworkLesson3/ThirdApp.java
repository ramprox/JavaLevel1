package ru.ramil.homeworkLesson3;

import java.util.Random;
import java.util.Scanner;

public class ThirdApp {
    static Scanner scan = new Scanner(System.in); // используем один объект Scanner
    static Random rand = new Random();            // и один объект Random для обеих игр

    public static void main(String[] args) {
        System.out.println("Выберите игру:");
        System.out.println("1 - Угадай число.");
        System.out.println("2 - Угадай слово.");
        int choose = scan.nextInt();
        switch (choose) {
            case 1:
                guessNumberGame();
                break;
            case 2:
                scan.nextLine(); // очистить буфер от символа перевода строки, т.к. следующий ввод будет ввод слова
                guessWordGame();
                break;
        }
    }

    // Игра "Угадай число"
    static void guessNumberGame() {
        int repeat;
        do {
            System.out.println();
            System.out.println("Добро пожаловать в игру \"Угадай число\"!!!");
            guessNumber();
            System.out.print("Повторить игру еще раз? 1 - да / 0 - нет: ");
            repeat = scan.nextInt();
        }while(repeat == 1);
    }

    static void guessNumber() {
        int bound = 10;
        int answer = rand.nextInt(bound);
        int tryCount = 3;
        do {
            int userAnswer = getNumberFromConsole(tryCount, bound - 1);
            if(userAnswer == answer) {
                System.out.println("Поздравляю!!! Вы угадали!!!");
                break;
            }
            else if(userAnswer > answer) {
                System.out.println("Введенное Вами число больше, чем загаданное");
            }
            else{
                System.out.println("Введенное Вами число меньше, чем загаданное");
            }
        }while(--tryCount > 0);
        if(tryCount < 1)
            System.out.println("Вы не угадали! Загаданное число " + answer);
    }

    static int getNumberFromConsole(int tryCount, int maxBound) {
        int x;
        do {
            String attempts = tryCount > 1 ? " попытки" : " попытка";  // можно усовершенствовать, если увеличить количество попыток
            System.out.print("Угадайте число от 0 до " + maxBound +
                    ". У Вас осталось " + tryCount + attempts + ": ");
            x = scan.nextInt();
        } while(x < 0 || x > maxBound);
        return x;
    }


    // Игра "Угадай слово"
    static void guessWordGame() {
        System.out.println("Добро пожаловать в игру \"Угадай слово\"!!!");
        System.out.println("Вводите ответы на английском языке маленькими буквами");
        String[] words = { "apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato" };
        String answer = words[rand.nextInt(words.length)];
        String userAnswer;
        while(true) {
            System.out.println();
            userAnswer = getWordFromConsole();
            if(isEquals(userAnswer, answer)) {
                System.out.println("Поздравляю!!! Вы угадали!!!");
                break;
            }
            System.out.println("Вы не угадали!");
            String diff = getMatches(userAnswer, answer);
            System.out.println("Ваш ответ:  " + userAnswer);
            System.out.println("Совпадения: " + diff);
        }
    }

    static String getWordFromConsole() {
        System.out.print("Введите Ваш ответ: ");
        return scan.nextLine();
    }

    static boolean isEquals(String userAnswer, String answer) {
        int userAnswerLength = userAnswer.length();
        int answerLength = answer.length();
        if(userAnswerLength != answerLength) {
            return false;
        }
        for(int i = 0; i < answerLength; i++) {
            if(userAnswer.charAt(i) != answer.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    static String getMatches(String userAnswer, String answer) {
        String result = "";
        int minLength = Math.min(userAnswer.length(), answer.length());
        int length = 15;  // общее количество символов в result
        for (int i = 0; i < minLength; i++) {
            char ch = userAnswer.charAt(i);
            result += ch == answer.charAt(i) ? ch : '#';
        }
        for(int i = 0; i < length - minLength; i++) {
            result += '#';
        }
        return result;
    }
}
