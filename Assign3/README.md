# Student Management System

This Java program demonstrates a menu-driven Student Management System where you can perform various operations on student records using classes, arrays of objects, and ArrayList.

## Assignment Description

The program consists of the following components:

- **Student Class (`Student.java`):**
  - Defines attributes for a student such as PRN, name, date of birth (DoB), and marks.
  - Provides methods to set and retrieve these attributes.

- **UserInput Class (`UserInput.java`):**
  - Manages an ArrayList of `Student` objects to perform CRUD operations.
  - Includes methods to:
    - Add students to the ArrayList.
    - Display all student records.
    - Search for a student by PRN.
    - Update student details (specifically name).
    - Delete a student from the ArrayList.

- **Main Class (`Main.java`):**
  - Implements a menu-driven interface using `Scanner` for user interaction.
  - Provides options to:
    1. Add a new student.
    2. Display all students.
    3. Search for a student by PRN.
    4. Update a student's name.
    5. Delete a student.
    6. Exit the program.

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
   - Choose from the menu options to perform various operations on student records.

## Author

- **Vaibhav Sharma**
- **Course:** AIML-B2
- **Date:** 2022-26
- **Student ID:** 22070126125

Feel free to explore and modify the program to suit your needs. This project serves as a basic example of object-oriented programming concepts and array manipulation in Java.
