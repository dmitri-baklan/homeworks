public class Triangle extends Shape {
    Point A;
    Point B;
    Point C;

    public Triangle(Point A, Point B, Point C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public Triangle(double a1, double a2, double b1, double b2,
                    double c1, double c2) {
        this.A = new Point(a1, a2);
        this.B = new Point(b1, b2);
        this.C = new Point(c1, c2);
    }

    @Override
    public void move(double dx, double dy) {
        A.setX(A.getX() + dx);
        A.setY(A.getY() + dy);
        B.setX(B.getX() + dx);
        B.setY(B.getY() + dy);
        C.setX(C.getX() + dx);
        C.setY(C.getY() + dy);
    }

    @Override
    public double square() {
        double sqr = Math.abs(((B.getX() - A.getX()) * (C.getY() - A.getY())) -
                ((C.getX() - A.getX()) * (B.getY() - A.getY())));
        return sqr;
    }

    @Override
    public double perimeter() {
        double AB = getAB();
        double BC = getBC();
        double AC = getAC();
        return AB + BC + AC;
    }

    public double getAB() {
        double len = Math.sqrt(Math.pow((B.getX() - A.getX()), 2) +
                Math.pow((B.getY() - A.getY()), 2));
        return len;
    }

    public double getBC() {
        double len = Math.sqrt(Math.pow((B.getX() - C.getX()), 2) +
                Math.pow((B.getY() - C.getY()), 2));
        return len;
    }

    public double getAC() {
        double len = Math.sqrt(Math.pow((A.getX() - C.getX()), 2) +
                Math.pow((A.getY() - C.getY()), 2));
        return len;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "AB=" + getAB() +
                "BC=" + getBC() +
                "AC=" + getAC() +
                super.toString() +
                '}';
    }

}
