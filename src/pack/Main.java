package pack;

public class Main {
    public static void main(String[] args) {
        new Robot().work();
        new CoffeRobot().work();
        new RobotDancer().work();
        new RobotCoocker().work();

        Robot[] robots = new Robot[4];
        robots[0] = new Robot();
        robots[1] = new CoffeRobot();
        robots[2] = new RobotDancer();
        robots[3] = new RobotCoocker();

        System.out.println("\n\n");

        for(int i = 0; i < robots.length; i++) {
            robots[i].work();
        }
    }
}
