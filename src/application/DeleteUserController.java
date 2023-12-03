package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserController {

    @FXML
    private TextField employeeIdField;


    // Method to delete employee data from the database
    public void deleteEmployee() {
        String sql = "DELETE FROM Employee WHERE employeeId = ?";

        try (Connection conn = DbThings.connect_to_mysql();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Assuming employee ID is an integer
            int employeeId = Integer.parseInt(employeeIdField.getText());
            pstmt.setInt(1, employeeId);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                // Handle case where no rows were affected, i.e., employee ID not found
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exception properly in a real-world application
        } catch (NumberFormatException e) {
            // Handle case where input is not a valid integer
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
    }}

