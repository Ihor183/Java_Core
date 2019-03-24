package ua.igorbendera.map;

import java.util.Objects;
import java.util.Scanner;

public class Person {
    private String fullName;
    private int age;

    public Person() { }

    public Person enterPerson() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Імя та прізвище людини : ");
        this.fullName = scanner.nextLine();

        System.out.print("Вік людини : ");
        this.age = scanner.nextInt();

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                fullName.equalsIgnoreCase(person.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, age);
    }

    @Override
    public String toString() {
        return "Person { " +
                " fullName = '" + fullName + '\'' +
                ", age = " + age +
                " }";
    }
}
