package ru.ramil.homeworkLesson7;

public class Cat {
    private final String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate plate) {
        System.out.println("Cat " + name + " is try eating...");
        if(plate.getFood() >= appetite) {
            plate.decreaseFood(appetite);
            appetite = 0;
            satiety = true;
        } else {
            satiety = false;
        }
    }

    public boolean getSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Cat " +
                "Name='" + name + '\'' +
                " Appetite=" + appetite +
                ", satiety=" + satiety;
    }
}
