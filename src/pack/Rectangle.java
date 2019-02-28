package pack;

public class Rectangle {
    private int width;
    private int height;

    Rectangle() {
        width = 15;
        height = 10;
    }

    Rectangle (int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int area() {
        return width * height;
    }

    public int perimeter() {
        return 2 * (width + height);
    }
}
