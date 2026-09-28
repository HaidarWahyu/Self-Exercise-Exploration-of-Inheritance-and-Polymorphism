public class Square extends Shape {
    private double side;

    public Square(double side, String color) {
        super(color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double area() {
        return side * side;
    }

    @Override
    public void printInfo() {
        System.out.printf("Square colored %s, area = %.2f%n", color, area());
    }
}
