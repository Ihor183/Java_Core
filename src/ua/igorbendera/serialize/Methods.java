package ua.igorbendera.serialize;

import java.io.*;
import java.util.ArrayList;

public class Methods {
    public static void serialize(File file, Serializable object) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, true));

        oos.writeObject(object);
        oos.close();
    }

    public static ArrayList<Employee> deserealize(File file) throws IOException, ClassNotFoundException {
        ArrayList<Employee> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream(file);

        while(true) {
            try {
                ObjectInputStream ois = new ObjectInputStream(fis);
                Employee object = (Employee) ois.readObject();
                list.add(object);

            } catch (EOFException e) {
                fis.close();
                return list;
            }
        }
    }
}
