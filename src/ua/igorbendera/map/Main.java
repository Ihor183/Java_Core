package ua.igorbendera.map;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ZooClub zooClub = new ZooClub();
        Scanner scanner = new Scanner(System.in);

        int action;
        boolean flag = false;

        while(!flag) {

            menu();
            action = scanner.nextInt();

            switch (action) {
                case 1: {
                    zooClub.addPerson(new Person().enterPerson());
                    break;
                }
                case 2: {
                    zooClub.addPet(new Person().enterPerson(), new Animal().enterAnimal());
                    break;
                }
                case 3: {
                    zooClub.removePet(new Person().enterPerson(), new Animal().enterAnimal());
                    break;
                }
                case 4: {
                    zooClub.removePerson(new Person().enterPerson());
                    break;
                }
                case 5: {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Введіть конкретний вид тваринки: ");
                    zooClub.removeSpecificAnimalFromAllPeople(sc.nextLine());
                    break;
                }
                case 6: {
                    zooClub.showZooClub();
                    break;
                }
                case 7: {
                    flag = true;
                    break;
                }
                default:
                    System.out.println("Некоректний ввід");
                    return;
            }
        }
    }

    static void menu() {
        System.out.println("\nВиберіть пункт: \n" +
                "1 - Додати учасника клубу\n" +
                "2 - Додати тваринку до учасника клубу\n" +
                "3 - Видалити тваринку з учасника клубу\n" +
                "4 - Видалити учасника з клубу\n" +
                "5 - Видалити конкретну тваринку зі всіх власників\n" +
                "6 - Вивести на екран зооклуб\n" +
                "7 - Вийти з програми");
    }
}
