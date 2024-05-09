# Deck of Cards Simulator

This Java program simulates a deck of cards using object-oriented programming concepts in Java. The deck of cards is represented as an array of `Card` objects, where each card has a value and suit.

## Assignment Description

The program includes the following components:

- **Card Class (`Card.java`):**
  - Defines a `Card` with private attributes for value and suit.
  - Provides methods to retrieve and set these attributes.
  - Overrides the `toString` method to represent the card as a string.

- **Deck Class (`Deck.java`):**
  - Manages a deck of 52 `Card` objects using an ArrayList.
  - Includes methods to:
    - Create a deck of cards with default and parameterized constructors.
    - Print the entire deck of cards.
    - Retrieve the top card from the deck.
    - Find cards of the same suit or rank.
    - Search for a specific card in the deck.
    - Deal 5 random cards from the deck.
    - Shuffle the deck of cards.

- **Main Class (`Main.java`):**
  - Implements a menu-driven interface using `Scanner` for user interaction.
  - Provides options to:
    1. Display the entire deck of cards.
    2. Find cards of the same suit.
    3. Compare cards with the same rank.
    4. Search for a specific card by suit and value.
    5. Deal 5 random cards from the deck.
    6. Shuffle the deck of cards.
    7. Exit the program.

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
   - Choose from the menu options to perform various operations on the deck of cards.

## Author

- **Vaibhav Sharma**
- **Course:** AIML-B2
- **Date:** 2022-26
- **Student ID:** 22070126125

Feel free to explore and modify the program to suit your needs. This project serves as a basic example of implementing a deck of cards and performing operations on it using Java classes and ArrayList.
