package ru.ramil.homeworkLesson5;

import java.util.Random;

public class TestPerson {

    private static final int MAX_AGE = 40;

    public static void main(String[] args) {
        int count = 5;
        Person[] persArray = new Person[count];
        int[] ages = getRandomAges(count);
        float[] salaries = getRandomSalaries(count);
        persArray[0] = new Person("Иванов Иван Иванович", "Генеральный директор",
                "ivanov@mail.ru", "8-999-999-99-99", salaries[0], ages[0]);
        persArray[1] = new Person("Петров Петр Петрович", "Зам. генерального директора",
                "petrov@mail.ru", "8-888-888-88-88", salaries[1], ages[1]);
        persArray[2] = new Person("Николаев Николай Николаевич", "Менеджер",
                "nikolaev@mail.ru", "8-777-777-77-77", salaries[2], ages[2]);
        persArray[3] = new Person("Михайлов Михаил Михайлович", "Инженер",
                "mixailov@mail.ru", "8-555-555-55-55", salaries[3], ages[3]);
        persArray[4] = new Person("Васильев Василий Васильевич", "Специалист",
                "vasilev@mail.ru", "8-444-444-44-44", salaries[4], ages[4]);

        for(Person p : persArray) {
            if(p.getAge() > MAX_AGE) {
                p.info();
                System.out.println();
            }
        }
    }

    private static int[] getRandomAges(int count) {
        int[] ages = new int[count];
        Random rand = new Random();
        for(int i = 0; i < count; i++) {
            ages[i] = rand.nextInt(40) + 20;
        }
        return ages;
    }

    private static float[] getRandomSalaries(int count) {
        float[] salaries = new float[count];
        Random rand = new Random();
        for(int i = 0; i < count; i++) {
            salaries[i] = rand.nextFloat() * 50000f + 20000f;
        }
        return salaries;
    }
}
