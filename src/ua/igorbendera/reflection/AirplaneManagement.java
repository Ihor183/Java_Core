package ua.igorbendera.reflection;

public class AirplaneManagement {
    void moveUp () {
        System.out.println("Літак буде переміщений вверх на " + (int)(Math.random() * 20) + " км");
    }
    void moveDown () {
        System.out.println("Літак буде переміщений вниз на " + (int)(Math.random() * 20) + " км");
    }
    void moveLeft () {
        System.out.println("Літак буде переміщений вліво на " + (int)(Math.random() * 20) + " км");
    }
    void moveRight () {
        System.out.println("Літак буде переміщений вправо на " + (int)(Math.random() * 20) + " км");
    }
}
