import java.util.Objects;

public class Main {
    public static void main(String... args) {
        Point p = new Point(1, 2);

        Circle circle = new Circle(p, 13d);
        System.out.println(circle.getCirc());

        Rectangle rect = new Rectangle(p, p);
        System.out.println(rect.RECTANGLE);

        rect = circle;

        System.out.println(circle.getCirc());
    }
}
