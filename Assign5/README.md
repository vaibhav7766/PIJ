# Shapes Java Program

This Java program implements a generic `Shapes` interface to define various geometric shapes such as circle, rectangle, square, sphere, cylinder, and pyramid. Each shape class implements methods to calculate its area, perimeter (where applicable), and volume (for 3D shapes).

## Assignment Description

The program includes the following components:

- **Shapes Interface (`Shape.java`):**
  - Declares abstract methods for calculating the shape's area and perimeter.
  - Provides a non-abstract method to display the selected shape.

- **Concrete Shape Classes:**
  1. **Circle (`Circle.java`):**
     - Implements `Shape` and `Volume` interfaces.
     - Calculates area and perimeter of a circle.

  2. **Rectangle (`Rectangle.java`):**
     - Implements `Shape` interface.
     - Calculates area and perimeter of a rectangle.

  3. **Square (`Square.java`):**
     - Implements `Shape` interface.
     - Calculates area and perimeter of a square.

  4. **Sphere (`Sphere.java`):**
     - Implements `Shape` and `Volume` interfaces.
     - Calculates surface area and volume of a sphere.

  5. **Cylinder (`Cylinder.java`):**
     - Implements `Shape` and `Volume` interfaces.
     - Calculates surface area and volume of a cylinder.

  6. **Pyramid (`Pyramid.java`):**
     - Implements `Shape` and `Volume` interfaces.
     - Calculates surface area and volume of a pyramid.

- **Main Class (`Main.java`):**
  - Implements a menu-driven interface using `Scanner` for user interaction.
  - Provides options to select a shape and calculate its area, perimeter, and volume (where applicable).

## Usage

1. **Compilation:**
   - Compile the Java files using:
     ```
     javac Main.java
     ```

2. **Execution:**
   - Run the compiled program using:
     ```
     java Main
     ```

3. **Menu Options:**
   - Choose a shape from the menu options to calculate its properties.
   - Enter the required dimensions (e.g., radius, length, width) for the selected shape.
   - The program will display the calculated area, perimeter, and volume (if applicable) based on the user's input.

## Author

- **Vaibhav Sharma**
- **Course:** AIML-B2
- **Date:** 2022-26
- **Student ID:** 22070126125

Feel free to explore and modify the program to add new shapes or extend the functionality. This project demonstrates the use of interfaces, abstract classes, and polymorphism in Java to model geometric shapes and calculate their properties.
