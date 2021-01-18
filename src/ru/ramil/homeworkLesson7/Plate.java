package ru.ramil.homeworkLesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int appetite) {
        this.food -= appetite;
        if(this.food < 0)
            this.food = 0;
    }

    public void increaseFood(int food) {
        this.food += food;
    }
}
