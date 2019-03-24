package ua.igorbendera.map;

import java.util.*;

public class ZooClub {
    private Map<Person, List<Animal>> map;

    public ZooClub() {
        map = new HashMap<>();
    }

    public void addPerson(Person person) {
        map.putIfAbsent(person, new ArrayList<>());
    }

    public void addPet(Person person, Animal animal) {
        if(checkIfPersonIsExist(person)) {
            if (checkIfPetIsExist(person, animal)) {
                map.get(person).add(animal);
                System.out.println("Тваринка успішно додана\n");
            } else {
                System.out.println("Ця тваринка вже є в зооклубі!\n");
            }
        }
    }

    public void removePet(Person person, Animal animal){
        if(checkIfPersonIsExist(person) && !checkIfPetIsExist(person, animal)) {
            map.get(person).remove(animal);
            System.out.println("Тваринка успішно видалена\n");
        }
    }

    public void removePerson(Person person) {
        if(checkIfPersonIsExist(person)) {
            map.remove(person);
            System.out.println("Учасник успішно видалений\n");
        }
    }

    public void removeSpecificAnimalFromAllPeople(String animalName) {
        Iterator<Map.Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry<Person, List<Animal>> next = iterator.next();

            Iterator<Animal> animalIterator = next.getValue().iterator();
            while(animalIterator.hasNext()) {
                Animal animal = animalIterator.next();

                if(animal.getAnimalType().equalsIgnoreCase(animalName)) {
                    animalIterator.remove();
                }
            }
        }

        System.out.println("Всіх \'" + animalName + "\' успішно видалено з зооклубу\n");
    }

    public void showZooClub() {
        map.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + "\n" + entry.getValue() + "\n");
        });
    }

    private boolean checkIfPersonIsExist(Person person) {
        if(map.get(person) != null) {
            return true;
        } else {
            System.out.println("Такого користувача немає в зооклубі!");
        }

        return false;
    }

    private boolean checkIfPetIsExist(Person person, Animal animal) {
        if(!(map.get(person).contains(animal))) {
            return true;
        }

        return false;
    }
}
