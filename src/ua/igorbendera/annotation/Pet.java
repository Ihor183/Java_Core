package ua.igorbendera.annotation;

import java.io.Serializable;

public class Pet implements Serializable {
    private String name;
    @CheckAnnotation("annotation pet type")
    private String kindOfAnimal;
    @CheckAnnotation("annotation pet age")
    private int age;

    public Pet(String name, String kindOfAnimal, int age) {
        this.name = name;
        this.kindOfAnimal = kindOfAnimal;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", kindOfAnimal='" + kindOfAnimal + '\'' +
                ", age=" + age +
                '}';
    }
}
