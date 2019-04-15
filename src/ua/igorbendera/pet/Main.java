package ua.igorbendera.pet;

public class Main {
    public static void main(String[] args) {
        Pet cow = System.out::println;
        Pet cat = System.out::println;
        Pet dog = System.out::println;

        cow.voice("Я корова - Мууу-Мууу");
        cat.voice("Я кіт - Мяууу-Мяууу");
        dog.voice("Я пес - Гаууу-Гаууу");
    }
}
