package pack_amphibia;

public class Main {
    public static void main(String[] args) {
        Object obj = new Frog();
        Amphibia frog = (Amphibia) obj;

        frog.eat();
        frog.sleep();
        frog.swin();
        frog.walk();
    }
}
