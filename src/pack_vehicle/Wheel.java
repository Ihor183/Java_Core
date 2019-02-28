package pack_vehicle;

public class Wheel {
    private int radius;
    private String season;
    private double tread_thickness;

    Wheel () {
        radius = 15;
        season = "winter";
        tread_thickness = 5.4;
    }

     Wheel(int radius, String season, double tread_thickness) {
        this.radius = radius;
        this.season = season;
        this.tread_thickness = tread_thickness;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public double getTread_thickness() {
        return tread_thickness;
    }

    public void setTread_thickness(double tread_thickness) {
        this.tread_thickness = tread_thickness;
    }

    @Override
    public String toString() {
        return " Wheel { " + "radius = " + radius + " | season = " + season + " | tread_thickness = " + tread_thickness + " }";
    }
}
