package ua.igorbendera.commodity;

import java.util.Objects;
import java.util.Scanner;

public class Commodity {
    private String name;
    private double weight;
    private double width;
    private double height;
    private String code;
    private int quantity;
    private Scanner scanner;

    public Commodity() {}

    public Commodity add() {
        scanner = new Scanner(System.in);

        System.out.print("Name : ");
        name = scanner.nextLine();
        System.out.print("Code : ");
        code = scanner.nextLine();
        System.out.print("Weight : ");
        weight = scanner.nextDouble();
        System.out.print("Width : ");
        width = scanner.nextDouble();
        System.out.print("Height : ");
        height = scanner.nextDouble();
        System.out.print("Quantity : ");
        quantity = scanner.nextInt();

        if(quantity <= 0 || weight <= 0 || width <= 0 || height <= 0) {
            setDefaultValue();
        }

        return this;
    }

    private void setDefaultValue() {
        quantity = 1;
        weight = 1;
        width = 10;
        height = 10;
    }

    public double getWeight() {
        return weight;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;
        return code.equals(commodity.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Commodity { " +
                " name = '" + name + '\'' +
                ", weight = " + weight +
                ", width = " + width +
                ", height = " + height +
                ", code = '" + code + '\'' +
                ", quantity = " + quantity +
                " }";
    }
}
