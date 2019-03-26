package ua.igorbendera.reflection;

public class Cy27 extends Plane implements SpecialPossibilities{
    private AirplaneManagement airplaneManagement;
    private int maxSpeed;
    private String color;

    public Cy27 () { }

    public Cy27(AirplaneManagement airplaneManagement, int maxSpeed, String color) {
        this.airplaneManagement = airplaneManagement;
        this.maxSpeed = maxSpeed;
        this.color = color;
    }

    public Cy27(double width, double height, double weight, AirplaneManagement airplaneManagement, int maxSpeed, String color) {
        super(width, height, weight);
        this.airplaneManagement = airplaneManagement;
        this.maxSpeed = maxSpeed;
        this.color = color;
    }

    public AirplaneManagement getAirplaneManagement() {
        return airplaneManagement;
    }

    @Override
    public String toString() {
        return "Cy27 { " +
                " maxSpeed = " + maxSpeed +
                ", color = '" + color + '\'' +
                '}';
    }

    @Override
    void startEngine() {
        System.out.println("До старту залишилося " + ((int)(Math.random() * 68) + 20) + " сек");
    }

    @Override
    void planeBoarding() {
        System.out.println("Літак йде на посадку");
    }

    @Override
    void planeTakeOff() {
        System.out.println("На повному баку палива літак пролетить " + Math.random() * 1000 + " км");
    }

    @Override
    public void accelerating() {
        maxSpeed = (int)(Math.random() * 200) + maxSpeed;
        System.out.println("Швидкість з турбо присторенням = " + maxSpeed + " км/год");
    }

    @Override
    public void Stealth() {
        System.out.println("Літака не видно протягом " + Math.random() * 100 + " сек");
    }

    @Override
    public void nuclearStrike() {
        System.out.println("Кількість ядерних боєголовок - " + (int)(Math.random() * 10) + " од.");
    }
}
