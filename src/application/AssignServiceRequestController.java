package application;
	
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AssignServiceRequestController {

    @FXML
    private ChoiceBox<String> serviceRequestChoiceBox;
    @FXML
    private ChoiceBox<String> departmentChoiceBox;



    // Method to initialize the choice boxes
    public void initialize() {
        loadServiceRequests();
        loadDepartments();
    }

    private void loadServiceRequests() {
        String sql = "SELECT requestId FROM ServiceRequest";
        try (Connection conn = DbThings.connect_to_mysql();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                serviceRequestChoiceBox.getItems().add(String.valueOf(rs.getInt("requestId")));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exception properly
        }
    }

    private void loadDepartments() {
        String sql = "SELECT departmentName FROM Department";
        try (Connection conn = DbThings.connect_to_mysql();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                departmentChoiceBox.getItems().add(rs.getString("departmentName"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exception properly
        }
    }

    // Method to assign the service request to a department
    public void assignServiceRequest() {
        String selectedRequest = serviceRequestChoiceBox.getValue();
        String selectedDepartment = departmentChoiceBox.getValue();

        int departmentId = getDepartmentId(selectedDepartment);
        if (departmentId != -1) {
            updateServiceRequest(Integer.parseInt(selectedRequest), departmentId);
        }
    }

    private int getDepartmentId(String departmentName) {
        String sql = "SELECT departmentId FROM Department WHERE departmentName = ?";
        try (Connection conn = DbThings.connect_to_mysql();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, departmentName);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("departmentId");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exception properly
        }
        return -1; // Indicate department not found or error
    }

    private void updateServiceRequest(int requestId, int departmentId) {
        String sql = "UPDATE ServiceRequest SET assignedDepartment = ? WHERE requestId = ?";

        try (Connection conn =DbThings.connect_to_mysql();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, departmentId);
            pstmt.setInt(2, requestId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exception properly
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
