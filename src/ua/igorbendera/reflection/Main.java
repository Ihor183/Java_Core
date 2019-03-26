package ua.igorbendera.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException {
        Class cy27 = Cy27.class;
        Class abstractPlane = Plane.class;

        System.out.println("Get class name = " + cy27.getName());
        System.out.println("Get simple class name = " + cy27.getSimpleName());
        System.out.println("Get class modifiers = " + Modifier.toString(cy27.getModifiers()));
        System.out.println("Get project package = " + cy27.getPackage());
        System.out.println("Get get super class = " + cy27.getSuperclass());
        System.out.println("Get interface = " + Arrays.toString(cy27.getInterfaces()));
        System.out.println("Is plane abstract = " + Modifier.isAbstract(abstractPlane.getModifiers()) + "\n\n");

        Constructor<Cy27>[] cy27Constructor = cy27.getConstructors();
        for(int i = 0; i < cy27Constructor.length; i++) {
            System.out.println((i + 1) + " constructor is " + cy27Constructor[i]);
            Class<?>[] parameterTypes = cy27Constructor[i].getParameterTypes();

            if(parameterTypes.length == 0) {
                System.out.println("Oops( This constructor doesn't have any parameters");
            } else {
                System.out.print("This constructor has this types of parameters" + "\n(");
            }

            for(int j = 0; j < parameterTypes.length; j++) {
                System.out.print(parameterTypes[j] + " ");
            }
            System.out.print(")\n\n");
        }

        Constructor<Cy27> constructor = cy27.getConstructor(AirplaneManagement.class, int.class, String.class);
        System.out.println("Get constructor by parameters = " + constructor);
        Cy27 newInstanceCy27 = constructor.newInstance(new AirplaneManagement(), 800, "black");
        System.out.println("Reflection cy27 = " + newInstanceCy27 + "\n\n");

        Field[] fields;
        fields = cy27.getDeclaredFields();
        if(fields.length != 0) {
            System.out.println("Class " + cy27.getSimpleName() + " has this fields");
        }
        for(int i = 0; i < fields.length; i++) {
            System.out.println(fields[i]);
        }

        //Set value to private field
        Field privateMaxSpeedField = fields[1];
        privateMaxSpeedField.setAccessible(true);
        privateMaxSpeedField.set(newInstanceCy27, 10000);
        System.out.println("\n\nGet private filed maxSpeed = " + privateMaxSpeedField.get(newInstanceCy27));

        //Get and invoke methods
        Method[] methods = cy27.getDeclaredMethods();
        System.out.println("\nClass " + cy27.getSimpleName() + " has this methods");
        for(int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
            methods[i].invoke(newInstanceCy27);
            System.out.println();
        }
    }
}
