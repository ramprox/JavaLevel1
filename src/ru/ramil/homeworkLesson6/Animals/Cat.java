package ru.ramil.homeworkLesson6.Animals;

public class Cat extends Animal {

    public Cat(String name, int age, String color) {
        super(name, age, color);
    }

    @Override
    public void voice() {
        System.out.println("Mяу!");
    }

    @Override
    public void jump() {
        System.out.println("Cat has jumped!");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
