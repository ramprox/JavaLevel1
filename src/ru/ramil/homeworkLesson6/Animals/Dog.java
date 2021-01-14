package ru.ramil.homeworkLesson6.Animals;

public class Dog extends Animal {

    protected final float maxSwimLength;

    private static int createdDogCount = 0;

    public Dog(String name, int age, String color) {
        this(name, age, color, 500, 10, 0.5f);
    }

    public Dog(String name, int age, String color,
               float maxRunLength, float maxSwimLength, float maxJumpHeight) {
        super(name, age, color, maxRunLength, maxJumpHeight);
        this.maxSwimLength = maxSwimLength;
        createdDogCount++;
    }

    public static int getCreatedDogCount() {
        return createdDogCount;
    }

    @Override
    public void voice() {
        System.out.println("Гав!");
    }

    @Override
    public void swim(float length) {
        printResult(length, maxSwimLength, ACTION_TYPE_SWIM);
    }

    @Override
    public String toString() {
        String info = super.toString();
        info = info.replace("Животное", "Собака");
        info += "Максимальное расстояние для плавания: " + maxSwimLength + "м\n";
        return info;
    }
}
