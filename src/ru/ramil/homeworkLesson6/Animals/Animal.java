package ru.ramil.homeworkLesson6.Animals;

public abstract class Animal {

    protected final String name;
    protected final String color;
    protected final int age;
    protected final float maxRunLength;
    protected final float maxJumpHeight;
    protected Message message;

    private static int animalCount = 0;

    protected Animal(String name, int age, String color) {
        this(name, age, color, 0, 0);
    }

    protected Animal(String name, int age, String color,
                     float maxRunLength, float maxJumpHeight) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.maxRunLength = maxRunLength;
        this.maxJumpHeight = maxJumpHeight;
        animalCount++;
    }

    public static int getCreatedAnimalCount() {
        return animalCount;
    }

    public abstract void voice();

    public void run(float length) {
        message = Message.run();
        printResult(length, maxRunLength);
    }

    public void swim(float length) {
        message = Message.swim();
        message.insertSuccessfulResult(name, length);
        System.out.println(message);
    }

    public void jump(float height) {
        message = Message.jump();
        printResult(height, maxJumpHeight);
    }

    protected void printResult(float size, float maxSize) {
        boolean isAbleToOvercome = size <= maxSize;
        if(isAbleToOvercome) {
            message.insertSuccessfulResult(name, size);
        } else {
            message.insertUnsuccessfulResult(name, size);
        }
        System.out.println(message);
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        String info = "Животное\n";
        info += "Имя: " + name + "\n";
        info += "Цвет: " + color + "\n";
        info += "Возраст: " + age + "\n";
        info += "Максимальное расстояние для забега: " + maxRunLength + "м\n";
        info += "Максимальная высота для прыжка: " + maxJumpHeight + "м\n";
        return info;
    }
}
