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

    protected static class Message {
        private static final String ACTION_TYPE_RUN = "бегать";
        private static final String ACTION_TYPE_SWIM = "плавать";
        private static final String ACTION_TYPE_JUMP = "прыгать";

        private final String actionType;
        private String message;

        private Message(String actionType) {
            this.actionType = actionType;
            this.message = "";
        }

        public static Message run() {
            return new Message(ACTION_TYPE_RUN);
        }

        public static Message swim() {
            return new Message(ACTION_TYPE_SWIM);
        }

        public static Message jump() {
            return new Message(ACTION_TYPE_JUMP);
        }

        public void insertSuccessfulResult(String name, float size) {
            message = name;
            switch (actionType) {
                case ACTION_TYPE_RUN:
                    message += " успешно пробежал(а) " + size + "м!";
                    break;
                case ACTION_TYPE_SWIM:
                    message += " успешно проплыл(а) " + size + "м!";
                    break;
                case ACTION_TYPE_JUMP:
                    message += " успешно перепрыгнул(а) через " + size + "м!";
                    break;
                default:
                    message += " успешно сделал(а)(о) это действие";
            }
        }

        public void insertUnsuccessfulResult(String name, float size) {
            message = name;
            switch (actionType) {
                case ACTION_TYPE_RUN:
                    message += " не может пробежать " + size + "м!";
                    break;
                case ACTION_TYPE_SWIM:
                    message += " не может проплыть " + size + "м!";
                    break;
                case ACTION_TYPE_JUMP:
                    message += " не может перепрыгнуть через " + size + "м!";
                    break;
                default:
                    message += " не может сделать это действие";
            }
        }

        @Override
        public String toString() {
            return message;
        }
    }
}
