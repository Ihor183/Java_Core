package pack_plane;

public class Main {
    public static void main(String[] args) {
        Cy27 cy27 = new Cy27(10, 5, 20, new AirplaneManagement(), 400, "gray");

        cy27.startEngine();
        cy27.planeTakeOff();
        cy27.getAirplaneManagement().moveUp();
        cy27.getAirplaneManagement().moveDown();
        cy27.getAirplaneManagement().moveLeft();
        cy27.getAirplaneManagement().moveRight();
        cy27.Stealth();
        cy27.nuclearStrike();
        cy27.accelerating();
        cy27.planeBoarding();
    }
}
