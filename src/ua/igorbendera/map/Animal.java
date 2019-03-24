package ua.igorbendera.map;

import java.util.Objects;
import java.util.Scanner;

public class Animal {
    private String animalType;
    private String animalName;

    public Animal() {}

    public Animal enterAnimal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Назва тваринки : ");
        this.animalName = scanner.nextLine();

        System.out.print("Тип тваринки : ");
        this.animalType = scanner.nextLine();

        return this;
    }

    public String getAnimalType() {
        return animalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return animalType.equalsIgnoreCase(animal.animalType) &&
                animalName.equalsIgnoreCase(animal.animalName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalType, animalName);
    }

    @Override
    public String toString() {
        return "Animal { " +
                " animalType = '" + animalType + '\'' +
                ", animalName = '" + animalName + '\'' +
                " }\n";
    }
}
