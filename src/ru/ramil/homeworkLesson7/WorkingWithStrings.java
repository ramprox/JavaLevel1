package ru.ramil.homeworkLesson7;

public class WorkingWithStrings {
    public static void main(String[] args) {
        String str = "I like Java!!!";
        print(str);
        printLastSymbol(str);
        System.out.println("'" + str + "'" + " end with '!!!' ? " + str.endsWith("!!!"));
        System.out.println("'" + str + "'" + " start with 'I like' ? " + str.startsWith("I like"));
        System.out.println("'" + str + "'" + " contains 'Java' ? " + str.contains("Java"));
        int indexWordJava = str.indexOf("Java");
        System.out.println("'Java' has " +  indexWordJava + " index in '" + str + "'");
        System.out.println(str.replace('a', 'o'));
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
        String strJava = str.substring(indexWordJava, indexWordJava + "Java".length());
        System.out.println(strJava);
    }

    private static void print(String info) {
        System.out.println(info);
    }

    private static void printLastSymbol(String str) {
        System.out.println(str.charAt(str.length() - 1));
    }
}
