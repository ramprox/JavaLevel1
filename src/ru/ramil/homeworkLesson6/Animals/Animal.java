package ru.ramil.homeworkLesson6.Animals;

public abstract class Animal {

    protected final String name;
    protected final String color;
    protected final int age;
    protected final float maxRunLength;
    protected final float maxJumpHeight;

    private static int animalCount = 0;

    private static final String ACTION_TYPE_RUN = "бегать";
    protected static final String ACTION_TYPE_SWIM = "плавать";
    private static final String ACTION_TYPE_JUMP = "прыгать";

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
        printResult(length, maxRunLength, ACTION_TYPE_RUN);
    }

    public void swim(float length) {
        System.out.println("Животное успешно проплыло " + length + "м!");
    }

    public void jump(float height) {
        printResult(height, maxJumpHeight, ACTION_TYPE_JUMP);
    }

    protected void printResult(float size, float maxSize, String actionType) {
        boolean isAbleToOvercome = size <= maxSize;
        String message;
        if(isAbleToOvercome) {
            message = getSuccessfulMessage(size, actionType);
        } else {
            message = getUnsuccessfulMessage(size, actionType);
        }
        System.out.println(message);
    }

    private String getSuccessfulMessage(float size, String actionType) {
        String result = name;
        switch (actionType) {
            case ACTION_TYPE_RUN:
                result += " успешно пробежал(а) ";
                break;
            case ACTION_TYPE_SWIM:
                result += " успешно проплыл(а) ";
                break;
            case ACTION_TYPE_JUMP:
                result += " успешно перепрыгнул(а) через ";
                break;
        }
        result += size + "м!";
        return result;
    }

    private String getUnsuccessfulMessage(float size, String actionType) {
        String result = name;
        switch (actionType) {
            case ACTION_TYPE_RUN:
                result += " не может пробежать ";
                break;
            case ACTION_TYPE_SWIM:
                result += " не может проплыть ";
                break;
            case ACTION_TYPE_JUMP:
                result += " не может перепрыгнуть через ";
        }
        result += size + "м!";
        return result;
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
