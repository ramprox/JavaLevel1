package ru.ramil.homeworkLesson6.Animals;

public abstract class Animal {

    protected final String name;
    protected final int age;
    protected final String color;

    public Animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public abstract void voice();
    public abstract void jump();

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
