package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class AddEmployeeController {

	    @FXML
	    private TextField lastNameField;
	    @FXML
	    private TextField firstNameField;
	    @FXML
	    private TextField employeeRoleField;
	    @FXML
	    private TextField departmentField;
	    @FXML
	    private TextField userNameField;
	    @FXML
	    private PasswordField passwordField;
	    @FXML
	    private TextField userStatusField;

	 

	    // Method to insert employee data into the database
	    public void addEmployee() {
	        String sql = "INSERT INTO Employee (lastName, employeeRole, firstName, department, userName, password, userStatus) VALUES (?, ?, ?, ?, ?, ?, ?)";

	        try (Connection conn = DbThings.connect_to_mysql();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            pstmt.setString(1, lastNameField.getText());
	            pstmt.setString(2, employeeRoleField.getText());
	            pstmt.setString(3, firstNameField.getText());
	            pstmt.setString(4, departmentField.getText());
	            pstmt.setString(5, userNameField.getText());
	            pstmt.setString(6, passwordField.getText()); // In a real-world application, you should hash the password before storing it
	            pstmt.setString(7, userStatusField.getText());

	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace(); // Handle exception properly in a real-world application
	        }
	    }
	    @FXML
	    void back(ActionEvent event) {
	        try {
	            // Load the home page (home.fxml)
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminHome.fxml"));
	            Parent root = loader.load();
	            Scene scene = new Scene(root);
	            
	            // Get the stage from the event source
	            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	            
	            // Set the new scene on the stage
	            stage.setScene(scene);
	        } catch (IOException e) {
	            e.printStackTrace();
	            // Handle any IO exceptions that may occur during loading
	        }
	    }
	    
	}


