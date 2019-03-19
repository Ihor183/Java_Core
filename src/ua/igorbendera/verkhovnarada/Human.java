package ua.igorbendera.verkhovnarada;

public class Human {
    private double weight;
    private double growth;

    public Human() {}

    public Human(double weight, double growth) {
        this.weight = weight;
        this.growth = growth;
    }

    public double getWeight() {
        return weight;
    }

    public double getGrowth() {
        return growth;
    }

    @Override
    public String toString() {
        return " вага = " + weight +
                ", ріст = " + growth;
    }
}
