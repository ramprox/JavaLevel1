package ru.ramil.homeworkLesson7;

public class Cat {
    private final String name;
    private int appetite;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        System.out.println("Cat is eating...");
        plate.decreaseFood(appetite);
        appetite = 0;
    }
}
