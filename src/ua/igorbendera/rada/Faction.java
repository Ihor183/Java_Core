package ua.igorbendera.rada;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Faction {
    private String factionName;
    private List<Deputy> deputies = new ArrayList<>();

    public Faction() {    }

    public Faction(String factionName) {
        this.factionName = factionName;
    }

    public Faction(String factionName, List<Deputy> deputies) {
        this.factionName = factionName;
        this.deputies = deputies;
    }

    public void addDeputy() {
        System.out.println("<---> Додати депутата у введену фракцію <--->");

        Deputy deputy = createDeputy();

        if(findDeputy(deputy)) {
            addOtherCharacteristics(deputy);
            deputies.add(deputy);
            System.out.println("Депутат успішно доданий");
        } else {
            System.out.println("Такий депутат вже існує");
        }

    }

    private Deputy createDeputy() {

        Supplier<Deputy> deputySupplier = () -> {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Імя : ");
            String name = scanner.nextLine();

            System.out.print("Прізвище: ");
            String surname = scanner.nextLine();

            System.out.print("Вік: ");
            int age = scanner.nextInt();

            return new Deputy(name, surname, age);
        };

        return deputySupplier.get();
    }

    private boolean findDeputy(Deputy deputy) {
        IsExistDeputy isExistDeputy = data -> {
            long count = deputies.stream().filter(data::equals).count();
            return count != 0;
        };

        return !isExistDeputy.checkDeputy(deputy);
    }

    private void addOtherCharacteristics(Deputy deputy) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Вага: ");
        double weight = scanner.nextDouble();
        deputy.setWeight(weight);

        System.out.print("Ріст: ");
        int height = scanner.nextInt();
        deputy.setHeight(height);

        System.out.print("Хабарник? Введіть (true або false): ");
        boolean bribe_taker = scanner.nextBoolean();
        deputy.setBribe_taker(bribe_taker);
    }


    public void removeDeputy() {
        System.out.println("<---> Видалити депутата з введеної фракції <--->");

        Deputy deputy = createDeputy();
        if(!findDeputy(deputy)) {
            deputies.remove(deputy);
            System.out.println("Депутат успішно видалений");
        } else {
            System.out.println("Такий депутат не існує");
        }
    }

    public void showBribeTakers() {
        System.out.println("<---> Список хабарників з фракції <--->");

        Collections.sort(deputies);

        deputies.forEach(d -> {
            if(d.isBribe_taker())
                System.out.println(d);
        });
    }


    public void mostBribeTakerIs() {
        System.out.println("<---> Найбільший хабарник у введеній фракції <--->");


        Collections.sort(deputies);
        if(deputies.get(0).isBribe_taker())
            System.out.println(deputies.get(0));
    }

    public void showDeputiesFaction() {
        Stream<Deputy> dep = deputies.stream().sorted(Comparator.comparing(Deputy::isBribe_taker, Comparator.reverseOrder()));

        dep.forEach(System.out::println);
    }

    public void clearFaction() {
        System.out.println("<---> Очистити введену фракцію від усіх депутатів <--->");

        deputies.clear();
        System.out.println("Фракція успішно очищена");
    }

    public Deputy getDeputy() {
        ListIterator<Deputy> deputyListIterator = deputies.listIterator();

        Deputy deputy = createDeputy();
        if(!findDeputy(deputy)) {
            while(deputyListIterator.hasNext()) {
                Deputy next = deputyListIterator.next();

                if(next.equals(deputy)) {
                    return next;
                }
            }
        } else {
            System.out.println("Такого депутата не існує");
        }

        return null;
    }

    public String getFactionName() {
        return factionName;
    }

    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    public List<Deputy> getDeputies() {
        return deputies;
    }

    public void setDeputies(List<Deputy> deputies) {
        this.deputies = deputies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faction faction = (Faction) o;
        return factionName.equalsIgnoreCase(faction.factionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(factionName);
    }

    @Override
    public String toString() {
        return " Faction - " + factionName + super.toString();
    }
}
