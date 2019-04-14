package ua.igorbendera.annotation;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException {

        Pet pet = new Pet("Jack", "Dog", 2);
        chooseFieldsWithAnnotation(pet, pet.getClass());

    }

    static void chooseFieldsWithAnnotation(Pet pet, Class c) throws IOException, IllegalAccessException {
        Field[] fields = c.getDeclaredFields();

        for(Field field: fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for(Annotation annotation : annotations) {
                if(annotation.annotationType().equals(CheckAnnotation.class)) {
                    field.setAccessible(true);
                    writeToFile(field, pet);
                }
            }
        }
    }

    static void writeToFile(Field field, Pet pet) throws IOException, IllegalAccessException {
        FileWriter fw = new FileWriter(new File("FieldWithAnnotation.txt"), true);
        String note = field.getName() + " - " + field.get(pet);

        fw.write(note);
        fw.append("\n");

        fw.flush();
        fw.close();
    }
}
