package pack_plane;

public abstract class Plane {
    private double width;
    private double height;
    private double weight;

    public Plane() { }

    public Plane(double width, double height, double weight) {
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    abstract void startEngine();
    abstract void planeBoarding();
    abstract void planeTakeOff();
}
