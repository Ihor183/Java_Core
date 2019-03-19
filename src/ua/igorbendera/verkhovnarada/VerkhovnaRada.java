package ua.igorbendera.verkhovnarada;

import java.util.*;

public class VerkhovnaRada {
    private List<Faction> factions = new ArrayList<>();

    public void addFaction() {
        System.out.println("<---> Додати фракцію <--->");
        String name = enterFactionName();

        if(!checkIfFactionIsExist(name)) {
            factions.add(new Faction(name));
            System.out.println("Фракція успішно додана");
        } else {
            System.out.println("Така фракція вже існує!");
        }

    }

    public void removeFaction() {
        System.out.println("<---> Видалити фракцію <--->");
        ListIterator<Faction> factionListIterator = factions.listIterator();
        String factionName = enterFactionName();

        while(factionListIterator.hasNext()) {
            Faction next = factionListIterator.next();

            if(next.getFactionName().equalsIgnoreCase(factionName)) {
                factionListIterator.remove();
                System.out.println("Фракція учпішно видалена");
            }
        }
    }

    public void showAllFactions() {
        System.out.println("<---> Переглянути всі фракції <--->");

        FactionNameComparator factionNameComparator = new FactionNameComparator();
        factions.sort(factionNameComparator);

        ListIterator<Faction> factionListIterator = factions.listIterator();

        while(factionListIterator.hasNext()) {
            Faction next = factionListIterator.next();
            System.out.println(next.toString());

            next.showDeputiesFaction();
        }
    }

    public void showFaction() {
        System.out.println("<---> Переглянути конкретну фракцію <--->");
        ListIterator<Faction> factionListIterator = factions.listIterator();
        String factionName = enterFactionName();

        while(factionListIterator.hasNext()) {
            Faction next = factionListIterator.next();

            if(next.getFactionName().equalsIgnoreCase(factionName)) {
                System.out.println(next.toString());
                next.showDeputiesFaction();
            }
        }
    }

    public Faction getFaction() {
        ListIterator<Faction> factionListIterator = factions.listIterator();
        String factionName = enterFactionName();

        while(factionListIterator.hasNext()) {
            Faction next = factionListIterator.next();

            if(next.getFactionName().equalsIgnoreCase(factionName)) {
                return next;
            }
        }

        return new Faction("");
    }

    public String enterFactionName() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть назву фракції");
        return scanner.nextLine();
    }

    private boolean checkIfFactionIsExist(String name) {
        ListIterator<Faction> factionListIterator = factions.listIterator();

        while(factionListIterator.hasNext()) {
            Faction next = factionListIterator.next();

            if(next.getFactionName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}