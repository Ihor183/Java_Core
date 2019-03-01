package pack_overload;

public class Student {
    private int age;
    private String name;

    Student () {
        this(20);
        System.out.println("Student age = " + age + " name = " + name);
    }

    public Student(int age) {
        this(age, "Igor");
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
