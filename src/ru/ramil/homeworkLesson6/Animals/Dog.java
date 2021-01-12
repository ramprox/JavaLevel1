package ru.ramil.homeworkLesson6.Animals;

public class Dog extends Animal {

    public Dog(String name, int age, String color) {
        super(name, age, color);
    }

    @Override
    public void voice() {
        System.out.println("Гав!");
    }

    @Override
    public void jump() {
        System.out.println("Dog has jumped!");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
