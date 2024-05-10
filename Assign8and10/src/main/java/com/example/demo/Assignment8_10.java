package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.sql.*;

public class Assignment8_10 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Employee Management System");

        stage.setWidth(500);
        stage.setHeight(600);
        stage.setResizable(false);

        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));

        String imagePath = "file:///C:/Users/vaibh/OneDrive/Desktop/demo/src/main/java/com/example/demo/778702.png";
        Image backgroundImage = new Image(imagePath);

        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false)
        );

        mainLayout.setBackground(new Background(background));

        Label employeeIDLabel = new Label("Employee ID");
        employeeIDLabel.setTextFill(Color.WHITE);
        employeeIDLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        TextField employeeIDField = new TextField();
        employeeIDField.setPromptText("Employee ID");

        Label nameLabel = new Label("Name");
        nameLabel.setTextFill(Color.WHITE);
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        Label ageLabel = new Label("Age");
        ageLabel.setTextFill(Color.WHITE);
        ageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        TextField ageField = new TextField();
        ageField.setPromptText("Age");

        Label emailLabel = new Label("Email");
        emailLabel.setTextFill(Color.WHITE);
        emailLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        Label departmentLabel = new Label("Department");
        departmentLabel.setTextFill(Color.WHITE);
        departmentLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        TextField departmentField = new TextField();
        departmentField.setPromptText("Department");

        Button createTableBtn = new Button("Create Table");
        Button deleteTableBtn = new Button("Delete Table");
        Button viewEmployeesBtn = new Button("View Employees");
        Button updateInfoBtn = new Button("Update Info");
        Button registerBtn = new Button("Register Employee");

        createTableBtn.setOnAction(event -> createEmployeeTable());
        deleteTableBtn.setOnAction(event -> deleteEmployeeTable());
        registerBtn.setOnAction(event -> registerEmployee(
                employeeIDField.getText(),
                nameField.getText(),
                ageField.getText(),
                emailField.getText(),
                departmentField.getText()
        ));
        viewEmployeesBtn.setOnAction(event -> viewEmployees());
        updateInfoBtn.setOnAction(event -> updateEmployeeInfo(
                employeeIDField.getText(),
                nameField.getText(),
                ageField.getText(),
                emailField.getText(),
                departmentField.getText()
        ));

        mainLayout.getChildren().addAll(
                createTableBtn, deleteTableBtn, viewEmployeesBtn, updateInfoBtn, registerBtn,
                employeeIDLabel, employeeIDField, nameLabel, nameField, ageLabel, ageField,
                emailLabel, emailField, departmentLabel, departmentField
        );

        Scene scene = new Scene(mainLayout, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    private void createEmployeeTable() {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "Pine@pple123");
             Statement statement = con.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS employees (" +
                    "id INT PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "age INT NOT NULL," +
                    "email VARCHAR(100) NOT NULL," +
                    "department VARCHAR(100) NOT NULL" +
                    ")";

            statement.executeUpdate(sql);
            System.out.println("Employee table created!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployeeTable() {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "Pine@pple123");
             Statement statement = con.createStatement()) {
            String sql = "DROP TABLE IF EXISTS employees";

            statement.executeUpdate(sql);
            System.out.println("Employee table deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void registerEmployee(String id, String name, String age, String email, String department) {
        if (!isTableExists()) {
            displayError("Error: Employee table does not exist!");
            return;
        }

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "Pine@pple123");
             PreparedStatement statement = con.prepareStatement(
                     "INSERT INTO employees (id, name, age, email, department) VALUES (?, ?, ?, ?, ?)")) {

            if (employeeExists(con, id)) {
                displayError("Error: Employee ID already exists!");
                return;
            }

            statement.setInt(1, Integer.parseInt(id));
            statement.setString(2, name);
            statement.setInt(3, Integer.parseInt(age));
            statement.setString(4, email);
            statement.setString(5, department);

            statement.executeUpdate();

            System.out.println("Employee registered successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean employeeExists(Connection con, String id) throws SQLException {
        PreparedStatement statement = con.prepareStatement("SELECT id FROM employees WHERE id = ?");
        statement.setInt(1, Integer.parseInt(id));
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next(); // Returns true if ID exists, false otherwise
    }

    private boolean isTableExists() {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "Pine@pple123")) {
            DatabaseMetaData metaData = con.getMetaData();
            try (ResultSet resultSet = metaData.getTables(null, null, "employees", null)) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void displayError(String errorMessage) {
        Label errorLabel = new Label(errorMessage);

        Stage errorStage = new Stage();
        errorStage.setTitle("Error");
        errorStage.setScene(new Scene(new StackPane(errorLabel), 300, 100));
        errorStage.show();
    }

    private void viewEmployees() {
        StringBuilder employeeDetails = new StringBuilder();

        if (!isTableExists()) {
            displayError("Error: Employee table does not exist!");
            return;
        }

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "Pine@pple123");
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM employees")) {

            employeeDetails.append("Registered Employees:\n\n");

            while (resultSet.next()) {
                employeeDetails.append("ID: ").append(resultSet.getInt("id")).append("\n");
                employeeDetails.append("Name: ").append(resultSet.getString("name")).append("\n");
                employeeDetails.append("Age: ").append(resultSet.getInt("age")).append("\n");
                employeeDetails.append("Email: ").append(resultSet.getString("email")).append("\n");
                employeeDetails.append("Department: ").append(resultSet.getString("department")).append("\n");
                employeeDetails.append("---------------------\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        TextArea textArea = new TextArea(employeeDetails.toString());
        textArea.setEditable(false);

        Stage employeeDetailsStage = new Stage();
        employeeDetailsStage.setTitle("Registered Employees");
        employeeDetailsStage.setScene(new Scene(new StackPane(textArea), 400, 300));
        employeeDetailsStage.show();
    }

    private void updateEmployeeInfo(String id, String name, String age, String email, String department) {
        if (!isTableExists()) {
            displayError("Error: Employee table does not exist!");
            return;
        }

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "Pine@pple123");
             PreparedStatement statement = con.prepareStatement(
                     "UPDATE employees SET name = ?, age = ?, email = ?, department = ? WHERE id = ?")) {

            statement.setString(1, name);
            statement.setInt(2, Integer.parseInt(age));
            statement.setString(3, email);
            statement.setString(4, department);
            statement.setInt(5, Integer.parseInt(id));

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Employee information updated successfully.");
            } else {
                System.out.println("No employee found with ID: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}