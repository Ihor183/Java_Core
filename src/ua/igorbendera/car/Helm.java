package ua.igorbendera.car;

public class Helm {
    private double diameter;
    private HelmMaterial material;

    public Helm(double diameter, HelmMaterial material) {
        this.diameter = diameter;
        this.material = material;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public HelmMaterial getMaterial() {
        return material;
    }

    public void setMaterial(HelmMaterial material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Helm{" +
                "diameter=" + diameter +
                ", material='" + material + '\'' +
                '}';
    }
}
