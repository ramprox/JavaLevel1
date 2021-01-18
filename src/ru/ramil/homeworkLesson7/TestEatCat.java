package ru.ramil.homeworkLesson7;

import java.util.Random;

public class TestEatCat {

    private static final Random rand = new Random();

    public static void main(String[] args) {
        Cat[] cats = createCats();
        testCats(cats);
    }

    private static Cat[] createCats() {
        String[] names = {"Barsik", "Pushistik", "Boris", "Markiz", "Pirat", "Knopka", "Tom"};
        int catCount = names.length;
        Cat[] cats = new Cat[catCount];
        for(int i = 0; i < catCount; i++) {
            cats[i] = new Cat(names[i], rand.nextInt(11) + 5);
        }
        return cats;
    }

    private static void testCats(Cat[] cats) {
        Plate plate = new Plate(rand.nextInt(31) + 10);
        for (Cat cat : cats) {
            System.out.println();
            plate.info();
            while(true) {
                cat.eat(plate);
                printResult(cat, plate);
                if(cat.getAppetite() == 0)
                    break;
                int increasedFood = rand.nextInt(11) + 5;
                plate.increaseFood(increasedFood);
                System.out.println("Food on the plate increased by " + increasedFood);
            }
        }
        System.out.println();

        plate.info();
        for(Cat cat : cats) {
            cat.printInfo();
        }
    }

    private static void printResult(Cat cat, Plate plate) {
        String result = "Cat " + cat.getName() + " is ";
        if(cat.getSatiety()) {
            result += "satiated.";
        } else {
            result += "not satiated because plate have " + plate.getFood()
                    + " food and cat " + cat.getName() +
                    " have appetite " + cat.getAppetite();
        }
        System.out.println(result);
    }
}
