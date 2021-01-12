package ru.ramil.homeworkLesson6;

import ru.ramil.homeworkLesson6.Animals.*;

public class Test {

    public static void main(String[] args) {
        Animal cat = new Cat("Barsik", 1, "Black");
        Animal dog = new Dog("Rex", 4, "White");

        System.out.println(cat);
        cat.voice();
        cat.jump();

        System.out.println();

        System.out.println(dog);
        dog.voice();
        dog.jump();
    }
}
