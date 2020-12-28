package ru.ramil.homeworkLesson5;

public class Person {
    private String name;
    private String position;
    private String email;
    private String phone;
    private float salary;
    private int age;

    public int getAge() {
        return age;
    }

    public Person(String name, String position, String email,
                  String phone, float salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public Person(String name, String position, float salary, int age) {
        this(name, position, null, null, salary, age);
    }

    public void info() {
        String info = "ФИО: " + name + ";\n";
        info += "Должность: " + position  + ";\n";
        info += "email: " + (email == null ? "-" : email) + ";\n";
        info += "Телефон: " + (phone == null ? "-" : phone) + ";\n";
        info += "Зарплата: " + salary + " р.;\n";
        info += "Возраст: " + age;
        System.out.println(info);
    }
}
