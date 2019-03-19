package ua.igorbendera.verkhovnarada;

import java.util.*;

public class Faction {
    private String factionName;
    private List<Deputy> deputies = new ArrayList<>();

    public Faction(String factionName) {
        this.factionName = factionName;
    }

    public void addDeputy() {
        System.out.println("<---> Додати депутата у введену фракцію <--->");
        Scanner scanner;

        double weight = 0.0;
        double growth = 0.0;
        String name = "";
        String surname= "";
        int age = 0;
        boolean bribe_taker = false;

        while(true) {
            try {
                scanner = new Scanner(System.in);
                System.out.print("Вага: ");
                weight = scanner.nextDouble();

                System.out.print("Ріст: ");
                growth = scanner.nextDouble();

                scanner = new Scanner(System.in);

                System.out.print("Імя : ");
                name = scanner.nextLine();

                System.out.print("Прізвище: ");
                surname = scanner.nextLine();

                System.out.print("Вік: ");
                age = scanner.nextInt();

                System.out.print("Хабарник? Введіть (true або false): ");
                bribe_taker = scanner.nextBoolean();
                break;

            } catch (RuntimeException ex) {
                System.out.println("Exception " + ex + "\n\n");
            }
        }

        Deputy deputy = new Deputy(weight, growth, name.trim(), surname.trim(), age, bribe_taker);

        if(!checkIfDeputyIsExist(deputy.getName() + deputy.getSurname() +
                deputy.getAge() + deputy.getWeight() + deputy.getGrowth())) {

            deputies.add(deputy);
            System.out.println("Депутат успішно доданий");
        } else {
            System.out.println("Такий депутат вже існує");
        }
    }

    public void removeDeputy() {
        System.out.println("<---> Видалити депутата з введеної фракції <--->");

        String fullData = findDeputy();

        ListIterator<Deputy> deputyListIterator = deputies.listIterator();

        while(deputyListIterator.hasNext()) {
            Deputy next = deputyListIterator.next();

            if((next.getName() + next.getSurname() + next.getAge()).equalsIgnoreCase(fullData)) {
                deputyListIterator.remove();
                System.out.println("Депутат успішно видалений");
            }
        }
    }

    public void showBribeTakers() {
        System.out.println("<---> Список хабарників з введеної фракції <--->");

        Collections.sort(deputies);

        ListIterator<Deputy> deputyListIterator = deputies.listIterator();

        while(deputyListIterator.hasNext()) {
            Deputy next = deputyListIterator.next();

            if(next.isBribe_taker()) {
                System.out.println(next.toString());
            }
        }
    }

    public void mostBribeTakerIs() {
        System.out.println("<---> Найбільший хабарник у введеній фракції <--->");

        Collections.sort(deputies);

        ListIterator<Deputy> deputyListIterator = deputies.listIterator();
        int bribe = 0;

        while(deputyListIterator.hasNext()) {
            Deputy next = deputyListIterator.next();

            if(next.isBribe_taker() && next.getSize_of_bribe() > bribe) {
                bribe = next.getSize_of_bribe();
            }
        }

        while(deputyListIterator.hasPrevious()) {
            Deputy previous = deputyListIterator.previous();

            if(previous.getSize_of_bribe() == bribe) {
                System.out.println(previous.toString());
            }
        }

    }

    public void showDeputiesFaction() {
        Collections.sort(deputies);
        ListIterator<Deputy> deputyListIterator = deputies.listIterator();

        while(deputyListIterator.hasNext()) {
            Deputy next = deputyListIterator.next();
            System.out.println(next.toString());
        }
    }

    public void clearFaction() {
        System.out.println("<---> Очистити введену фракцію від усіх депутатів <--->");
        ListIterator<Deputy> deputyListIterator = deputies.listIterator();

        while(deputyListIterator.hasNext()) {
            deputyListIterator.next();
            deputyListIterator.remove();
        }
        System.out.println("Фракція успішно очищена");
    }

    public String findDeputy() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Імя");
        String name = scanner.nextLine();

        System.out.println("Прізвище");
        String surname = scanner.nextLine();

        System.out.println("Вік");
        int age = scanner.nextInt();

        return name.trim() + surname.trim() + age;
    }

    public Deputy getDeputy() {
        String fullData = findDeputy();

        ListIterator<Deputy> deputyListIterator = deputies.listIterator();

        while(deputyListIterator.hasNext()) {
            Deputy next = deputyListIterator.next();

            if((next.getName() + next.getSurname() + next.getAge()).equalsIgnoreCase(fullData)) {
                return next;
            }
        }

        return new Deputy();
    }

    public String getFactionName() {
        return factionName;
    }

    public boolean checkIfDeputyIsExist(String data) {
        ListIterator<Deputy> deputyListIterator = deputies.listIterator();

        while(deputyListIterator.hasNext()) {
            Deputy next = deputyListIterator.next();

            if((next.getName() + next.getSurname() + next.getAge() +
                    next.getWeight() + next.getGrowth()).equalsIgnoreCase(data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nФракція { " +
                " назва фракції = '" + factionName + "\' " +
                " }\n";
    }
}
