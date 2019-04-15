package ua.igorbendera.amphibia;

public class Main {
    public static void main(String[] args) {
        State eat = System.out::println;
        State sleep = System.out::println;
        State swim = System.out::println;
        State walk = System.out::println;

        eat.currentState("I wanna eat");
        sleep.currentState("I wanna sleep");
        swim.currentState("I wanna swim");
        walk.currentState("I wanna walk");
    }
}
