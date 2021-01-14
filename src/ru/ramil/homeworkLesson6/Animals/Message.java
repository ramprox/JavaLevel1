package ru.ramil.homeworkLesson6.Animals;

class Message {
    private static final String ACTION_TYPE_RUN = "бегать";
    private static final String ACTION_TYPE_SWIM = "плавать";
    private static final String ACTION_TYPE_JUMP = "прыгать";

    private final String actionType;
    private String message;

    public Message(String actionType) {
        this.actionType = actionType;
        this.message = "";
    }

    public static Message run() {
        return new Message(Message.ACTION_TYPE_RUN);
    }

    public static Message swim() {
        return new Message(Message.ACTION_TYPE_SWIM);
    }

    public static Message jump() {
        return new Message(Message.ACTION_TYPE_JUMP);
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
