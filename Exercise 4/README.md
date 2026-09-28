# Name : Haidar Wahyu Yasari

# NIM : F1D02410114

# PBO Exercise: Shape, Square, Circle, and Cylinder

## Project Structure

```
PBOExercise/
├── Shape.java       # parent class (abstract)
├── Square.java      # child of Shape
├── Circle.java      # child of Shape
├── Cylinder.java    # child of Circle
├── Main.java        # main program
└── README.md
```

Inheritance hierarchy: `Shape` → `Square`, `Shape` → `Circle` → `Cylinder`.

## How to Run

```bash
javac *.java
java Main
```

## Sample Output

```
==========================================
   OBJECT EXPLORATION: SHAPE, SQUARE,
        CIRCLE, AND CYLINDER
==========================================

--- Object Info ---
1. Square colored red, area = 25.00
2. Circle blue, area = 28.27
3. Cylinder green, volume = 282.74

--- Calculation Results ---
Square Area      : 25.00
Circle Area      : 28.27
Cylinder Volume  : 282.74

--- Getter and Setter ---
Square color before : red
Square color after  : yellow
Latest info         : Square colored yellow, area = 25.00

==========================================
```

---

## OOP Concepts in the Code

### 1. Abstraction

Abstraction means hiding implementation details and only exposing what a class must provide. In this project it is applied through an **abstract class** and an **abstract method** in `Shape`.

**`Shape.java`**: the class is declared `abstract`, so `Shape` cannot be instantiated directly (`new Shape("red")` would cause a compile error).

```java
public abstract class Shape {
```

**`Shape.java`**: the method `printInfo()` is declared `abstract`, meaning it only has a name and a return type, with no body. Every child class must provide its own implementation.

```java
public abstract void printInfo();
```

`Shape` only defines the rule that every shape must be able to display its info. How it is displayed is left to each shape (`Square`, `Circle`, `Cylinder`).

---

### 2. Encapsulation

Encapsulation means bundling data (attributes) inside a class and restricting direct access from outside. Attributes are declared `private` or `protected`, and are accessed through **getter** and **setter** methods.

**Encapsulated attributes**

`Shape.java` (`protected`, accessible by child classes):

```java
protected String color;
```

`Square.java` (`private`, accessible only inside `Square`):

```java
private double side;
```

`Circle.java` (`protected`, so the child class `Cylinder` can use it):

```java
protected double radius;
```

`Cylinder.java` (`private`):

```java
private double height;
```

**Getters and setters**

`Shape.java`:

```java
public String getColor() {
    return color;
}

public void setColor(String color) {
    this.color = color;
}
```

`Square.java`:

```java
public double getSide() {
    return side;
}

public void setSide(double side) {
    this.side = side;
}
```

`Circle.java`:

```java
public double getRadius() {
    return radius;
}

public void setRadius(double radius) {
    this.radius = radius;
}
```

`Cylinder.java`:

```java
public double getHeight() {
    return height;
}

public void setHeight(double height) {
    this.height = height;
}
```

**Usage in `Main.java`**: the value of `color` is not changed directly, but through `getColor()` and `setColor()`.

```java
System.out.println("Square color before : " + square.getColor());
square.setColor("yellow");
System.out.println("Square color after  : " + square.getColor());
```

---

### 3. Inheritance

Inheritance is the ability of a class to reuse attributes and methods from another class using the `extends` keyword, so code does not have to be written again.

**Inheritance declarations**

`Square.java`, `Square` inherits from `Shape`:

```java
public class Square extends Shape {
```

`Circle.java`, `Circle` inherits from `Shape`:

```java
public class Circle extends Shape {
```

`Cylinder.java`, `Cylinder` inherits from `Circle` (multilevel inheritance, so it also indirectly inherits from `Shape`):

```java
public class Cylinder extends Circle {
```

**Calling the parent constructor with `super`**

`Square.java`, `super(color)` sets the `color` attribute defined in `Shape`:

```java
public Square(double side, String color) {
    super(color);
    this.side = side;
}
```

`Circle.java`:

```java
public Circle(double radius, String color) {
    super(color);
    this.radius = radius;
}
```

`Cylinder.java`, `super(radius, color)` calls the `Circle` constructor:

```java
public Cylinder(double height, double radius, String color) {
    super(radius, color);
    this.height = height;
}
```

**Using an inherited method**

`Cylinder.java`: `area()` is not written in `Cylinder`, it is inherited from `Circle` and reused to calculate the volume (base area × height).

```java
public double volume() {
    return area() * height;
}
```

In addition, the `Square`, `Circle`, and `Cylinder` objects in `Main.java` can call `getColor()` and `setColor()` even though those methods are written in `Shape`. A `Cylinder` object can also call `getRadius()` and `area()` from `Circle`.

---

### 4. Polymorphism

Polymorphism means one method name can behave differently depending on the object. Here it is applied through **method overriding**: `printInfo()` is declared in `Shape`, then rewritten (`@Override`) in each child class.

**`Square.java`**

```java
@Override
public void printInfo() {
    System.out.printf("Square colored %s, area = %.2f%n", color, area());
}
```

**`Circle.java`**

```java
@Override
public void printInfo() {
    System.out.printf("Circle %s, area = %.2f%n", color, area());
}
```

**`Cylinder.java`**

```java
@Override
public void printInfo() {
    System.out.printf("Cylinder %s, volume = %.2f%n", color, volume());
}
```

The method name is the same (`printInfo`), but the behavior differs: `Square` and `Circle` display the area, while `Cylinder` displays the volume.

**Usage in `Main.java`**: three objects call a method with the same name, but the result differs depending on the object type.

```java
System.out.print("1. ");
square.printInfo();
System.out.print("2. ");
circle.printInfo();
System.out.print("3. ");
cylinder.printInfo();
```

Result:

```
1. Square colored red, area = 25.00
2. Circle blue, area = 28.27
3. Cylinder green, volume = 282.74
```

`Cylinder` also overrides the `printInfo()` of `Circle`. That is why a `Cylinder` object displays the volume instead of the area, even though `Circle` already has its own version of `printInfo()`.

---

## Summary

| Concept       | Keywords in the code                          | Main location                                                        |
| ------------- | --------------------------------------------- | -------------------------------------------------------------------- |
| Abstraction   | `abstract class`, `abstract void printInfo()` | `Shape.java`                                                         |
| Encapsulation | `private`, `protected`, getters/setters       | All classes; usage in `Main.java`                                    |
| Inheritance   | `extends`, `super(...)`                       | `Square`, `Circle`, `Cylinder` (class declarations and constructors) |
| Polymorphism  | `@Override printInfo()`                       | `Square`, `Circle`, `Cylinder`                                       |
