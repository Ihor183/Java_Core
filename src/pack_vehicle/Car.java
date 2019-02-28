package pack_vehicle;

public class Car {
    private int max_speed;
    private double weight;
    private String transmission;
    private Helm helm;
    private Wheel wheel;
    private Body body;

    Car () {
        max_speed = 200;
        weight = 1.35;
        transmission = "Manual";
        helm = new Helm();
        wheel = new Wheel();
        body = new Body();
    }

    public Car(int max_speed, double weight, String transmission, String material, float helm_weight, String form,
               int radius, String season, double tread_thickness, String color, String type) {
        this.max_speed = max_speed;
        this.weight = weight;
        this.transmission = transmission;
        this.helm = new Helm(material, helm_weight, form);
        this.wheel = new Wheel(radius, season, tread_thickness);
        this.body = new Body(color, type);
    }

    public int getMax_speed() {
        return max_speed;
    }

    public void setMax_speed(int max_speed) {
        this.max_speed = max_speed;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public Helm getHelm() {
        return helm;
    }

    public void setHelm(Helm helm) {
        this.helm = helm;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Car { " + "max_speed = " + max_speed + " | weight = " + weight + " | transmission = " + transmission + " : "
                + helm.toString() + wheel.toString() + body.toString() + " }";
    }
}
