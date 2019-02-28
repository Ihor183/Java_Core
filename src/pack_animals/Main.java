package pack_animals;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Elephant", 5, 6);

        System.out.println("Назва тварини = " + animal.getName() + ", Швидкість тварини = " + animal.getSpeed() +
                " км/год, Вік тварини = " + animal.getAge() + " років "+ "\n------------------------------------" +
                "-------------------------------------------" );

        animal.setName("Tiger");
        animal.setSpeed(60);
        animal.setAge(3);

        System.out.println("Назва тварини = " + animal.getName() + ", Швидкість тварини = " + animal.getSpeed() +
                " км/год, Вік тварини = " + animal.getAge() + " років " );
    }
}
