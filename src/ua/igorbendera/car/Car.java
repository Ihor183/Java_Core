package ua.igorbendera.car;

public class Car {
    private int numberOfHorsepower;
    private Helm helm;
    private Engine engine;

    public Car(int numberOfHorsepower, Helm helm, Engine engine) {
        this.numberOfHorsepower = numberOfHorsepower;
        this.helm = helm;
        this.engine = engine;
    }

    public int getNumberOfHorsepower() {
        return numberOfHorsepower;
    }

    public void setNumberOfHorsepower(int numberOfHorsepower) {
        this.numberOfHorsepower = numberOfHorsepower;
    }

    public Helm getHelm() {
        return helm;
    }

    public void setHelm(Helm helm) {
        this.helm = helm;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "\nCar { " +
                "Horsepower = " + numberOfHorsepower +
                ", " + helm.toString() +
                ", " + engine.toString() +
                " }";
    }
}
