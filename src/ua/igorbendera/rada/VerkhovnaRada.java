package ua.igorbendera.rada;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.function.Supplier;

public class VerkhovnaRada {
    private List<Faction> factions = new ArrayList<>();

    public void addFaction() {
        System.out.println("<---> Додати фракцію <--->");

        Faction faction = createFaction();
        if(!findFaction(faction)) {
            factions.add(faction);
        }
    }

    private Faction createFaction() {
        Supplier<Faction> factionSupplier = () -> {
            System.out.print("Назва: ");
            String name = new Scanner(System.in).nextLine();

            return new Faction(name);
        };

        return factionSupplier.get();
    }

    private boolean findFaction(Faction faction) {
        return factions.contains(faction);
    }

    public void removeFaction() {
        System.out.println("<---> Видалити фракцію <--->");

        Faction faction = createFaction();
        if(findFaction(faction)) {
            factions.remove(faction);
            System.out.println("Фракція успішно видалена");
        } else {
            System.out.println("Не існує такої фракції");
        }
    }

    public void showAllFactions() {
        System.out.println("<---> Переглянути всі фракції <--->");

        FactionNameComparator factionNameComparator = new FactionNameComparator();
        factions.sort(factionNameComparator);

        factions.forEach(x -> {
            System.out.println(x.getFactionName());
            x.showDeputiesFaction();
        });
    }

    public void showFaction() {
        System.out.println("<---> Переглянути конкретну фракцію <--->");

        Faction faction = createFaction();
        if(findFaction(faction)) {
            factions.forEach(x -> {
                if(x.getFactionName().equalsIgnoreCase(faction.getFactionName()))
                    x.showDeputiesFaction();
            });
        } else {
            System.out.println("Не існує такої фракції");
        }
    }

    public Faction getFaction() {
        ListIterator<Faction> factionListIterator = factions.listIterator();

        Faction faction = createFaction();
        if(findFaction(faction)) {
            while(factionListIterator.hasNext()) {
                Faction next = factionListIterator.next();

                if(next.equals(faction)) {
                    return next;
                }
            }
        } else {
            System.out.println("Такої фракції не існує");
        }

        return null;
    }
}
