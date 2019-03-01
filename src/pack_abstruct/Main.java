package pack_abstruct;

public class Main {
    public static void main(String[] args) {
        Pet dog = new Dog();
        Pet cow = new Cow();
        Pet cat = new Cat();

        dog.voice();
        cow.voice();
        cat.voice();
    }
}
