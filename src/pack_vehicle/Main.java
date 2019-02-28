package pack_vehicle;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();

        Car car1 = new Car(300, 1.789, "Automatic", "leather", 1.0F, "circle",
                20, "summer", 4.7, "dark", "coupe");

        System.out.println(car.toString());
        System.out.println(car1.toString());

        car1.setMax_speed(350);
        car1.setTransmission("Manual");
        car1.setWeight(1.5);
        car1.getHelm().setMaterial("suede");
        car1.getHelm().setWeight(0.9F);
        car1.getHelm().setForm("oval");
        car1.getWheel().setRadius(21);
        car1.getWheel().setSeason("winter");
        car1.getWheel().setTread_thickness(4.0);
        car1.getBody().setColor("red");
        car1.getBody().setType("crossover");

        System.out.println("After change \n" + car1.toString());

    }
}
