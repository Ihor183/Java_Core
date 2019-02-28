package pack;

public class Circle {
    private double radius;
    private double diametr;

    Circle () {
        radius = 5.5;
        diametr = 11;
    }

    Circle (double radius, double diametr) {
        this.radius = radius;
        this.diametr = diametr;
    }

    public double circleLength() {
        return 2 * Math.PI * radius;
    }

    public double circleArea() {
        return Math.PI / 4 * Math.pow(diametr, 2);
    }
}
