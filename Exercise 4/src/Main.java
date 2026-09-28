public class Main {
    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("   OBJECT EXPLORATION: SHAPE, SQUARE,");
        System.out.println("        CIRCLE, AND CYLINDER");
        System.out.println("==========================================");

        Square square = new Square(5, "red");
        Circle circle = new Circle(3, "blue");
        Cylinder cylinder = new Cylinder(10, 3, "green");

        System.out.println();
        System.out.println("--- Object Info ---");
        System.out.print("1. ");
        square.printInfo();
        System.out.print("2. ");
        circle.printInfo();
        System.out.print("3. ");
        cylinder.printInfo();

        System.out.println();
        System.out.println("--- Calculation Results ---");
        System.out.printf("Square Area      : %.2f%n", square.area());
        System.out.printf("Circle Area      : %.2f%n", circle.area());
        System.out.printf("Cylinder Volume  : %.2f%n", cylinder.volume());

        System.out.println();
        System.out.println("--- Getter and Setter ---");
        System.out.println("Square color before : " + square.getColor());
        square.setColor("yellow");
        System.out.println("Square color after  : " + square.getColor());
        System.out.print("Latest info         : ");
        square.printInfo();

        System.out.println();
        System.out.println("==========================================");
    }
}
