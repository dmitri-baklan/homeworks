
public class Shape {
    public String SHAPE = "SHAPE";


    public double square() {
        return 0;
    }

    public double perimeter() {
        return 0;
    }

    public void move(double dx, double dy) {

    }

    @Override
    public String toString() {
        return ", perimeter = " + perimeter() +", square = " +square();
    }
}