package ru.ramil.homeworkLesson6.Animals;

public class Cat extends Animal {

    private static int createdCatCount = 0;

    public Cat(String name, int age, String color) {
        this(name, age, color, 200, 2);
    }

    public Cat(String name, int age, String color,
               float maxRunLength, float maxJumpHeight) {
        super(name, age, color, maxRunLength, maxJumpHeight);
        createdCatCount++;
    }

    public static int getCreatedCatCount() {
        return createdCatCount;
    }

    @Override
    public void voice() {
        System.out.println("Мяу!");
    }

    @Override
    public void swim(float length) {
        System.out.println("Кошка не может плавать!");
    }

    @Override
    public String toString() {
        String info = super.toString();
        info = info.replace("Животное", "Кошка");
        return info;
    }
}
