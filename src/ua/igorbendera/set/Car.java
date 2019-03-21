package ua.igorbendera.set;

import java.util.Objects;

public class Car implements Comparable<Car>{
    private String brand;
    private String model;
    private int power;

    public Car(String brand, String model, int power) {
        this.brand = brand;
        this.model = model;
        this.power = power;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return power == car.power &&
                brand.equals(car.brand) &&
                model.equals(car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, power);
    }

    @Override
    public String toString() {
        return "Car {" +
                " brand = '" + brand + '\'' +
                ", model = '" + model + '\'' +
                ", power = " + power +
                " }";
    }

    @Override
    public int compareTo(Car o) {
        if(this.power < o.getPower()) {
            return 1;
        } else if(this.power > o.getPower()) {
            return -1;
        } else {
            if(this.brand.compareToIgnoreCase(o.getBrand()) > 0) {
                return 1;
            } else if(this.brand.compareToIgnoreCase(o.getBrand()) < 0) {
                return -1;
            } else {
                if(this.model.compareToIgnoreCase(o.getModel()) > 0) {
                    return 1;
                } else if(this.model.compareToIgnoreCase(o.getModel()) < 0) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
