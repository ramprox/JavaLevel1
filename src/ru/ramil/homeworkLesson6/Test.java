package ru.ramil.homeworkLesson6;

import ru.ramil.homeworkLesson6.Animals.*;

import java.util.Random;

public class Test {

    private static final Random rand = new Random();

    public static void main(String[] args) {
        Animal[] cats = getCats();
        Animal[] dogs = getDogs();
        System.out.println("Тестирование котов...");
        testAnimals(cats);
        System.out.println();
        System.out.println("Тестирование собак...");
        testAnimals(dogs);
        printCreatedAnimalCount();
    }

    private static Animal[] getCats() {
        Animal[] cats = new Animal[4];
        cats[0] = new Cat("Барсик", 1, "Черный", 25, 3);
        cats[1] = new Cat("Васька", 2, "Серый", 40, 2.5f);
        cats[2] = new Cat("Пушистик", 3, "Белый", 30, 2);
        cats[3] = new Cat("Борис", 4, "Рыжий");
        return cats;
    }

    private static Animal[] getDogs() {
        Animal[] dogs = new Animal[5];
        dogs[0] = new Dog("Рекс", 4, "Белый", 20, 20, 1);
        dogs[1] = new Dog("Шарик", 2, "Черный", 30, 30, 1.5f);
        dogs[2] = new Dog("Полкан", 1, "Коричневый", 40, 40, 1.3f);
        dogs[3] = new Dog("Бим", 5, "Черно-белый", 50, 50, 0.5f);
        dogs[4] = new Dog("Казбек", 3, "Серый");
        return dogs;
    }

    private static void testAnimals(Animal[] animals) {
        for (Animal animal : animals) {
            animal.printInfo();
            animal.run(round(rand.nextFloat() * 50, 1));
            animal.jump(round(rand.nextFloat() * 5.5f, 1));
            animal.swim(round(rand.nextFloat() * 20, 1));
            animal.voice();
            System.out.println();
        }
    }

    private static void printCreatedAnimalCount() {
        System.out.println("Всего создано " + Cat.getCreatedCatCount() + " котов.");
        System.out.println("Всего создано " + Dog.getCreatedDogCount() + " собак.");
        System.out.println("Всего создано " + Animal.getCreatedAnimalCount() + " животных.");
    }

    private static float round(float value, int digits) {
        int tenInExpDigits = (int)Math.pow(10, digits);
        value *= tenInExpDigits;
        value = (float)Math.round(value) / tenInExpDigits;
        return value;
    }
}
