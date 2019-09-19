package pack;

//Repository was changed
public class Main {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle(50, 20);

        System.out.println("Площа прямокутника 1 = " + rectangle1.area());
        System.out.println("Периметр прямокутника 1 = " + rectangle1.perimeter());

        System.out.println("\nПлоща прямокутника 2 = " + rectangle2.area());
        System.out.println("Периметр прямокутника 2 = " + rectangle2.perimeter());

        Circle circle1 = new Circle();
        Circle circle2 = new Circle(2.3, 4.6);

        System.out.println("\nДовжина кола 1 = " + String.format("%4.2f", circle1.circleLength()));
        System.out.println("Площа кола 1 = " + String.format("%4.2f", circle1.circleArea()));

        System.out.println("\nДовжина кола 2 = " + String.format("%4.2f", circle2.circleLength()));
        System.out.println("Площа кола 2 = " + String.format("%4.2f", circle2.circleArea()));
    }
}
