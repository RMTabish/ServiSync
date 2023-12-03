package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class ResourceAllocationController {

    @FXML
    private TextField resourceTypeField;
    @FXML
    private ChoiceBox<String> serviceRequestChoiceBox;
    @FXML
    private TextField quantityField;
    @FXML
    private DatePicker allocationDatePicker;


    // Method to initialize the choice box
    public void initialize() {
        loadServiceRequests();
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

    public void allocateResource() {
        String selectedRequest = serviceRequestChoiceBox.getValue();
        int departmentId = getDepartmentIdForServiceRequest(Integer.parseInt(selectedRequest));

        String sql = "INSERT INTO ResourceAllocation (resourceType, associatedServiceReq, assignedDept, quantity, allocationDate) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DbThings.connect_to_mysql();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, resourceTypeField.getText());
            pstmt.setInt(2, Integer.parseInt(selectedRequest));
            pstmt.setInt(3, departmentId);
            pstmt.setInt(4, Integer.parseInt(quantityField.getText()));
            pstmt.setDate(5, java.sql.Date.valueOf(allocationDatePicker.getValue()));

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
    private int getDepartmentIdForServiceRequest(int serviceRequestId) {
        String sql = "SELECT assignedDepartment FROM ServiceRequest WHERE requestId = ?";
        try (Connection conn = DbThings.connect_to_mysql();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, serviceRequestId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("assignedDepartment");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exception properly
        }
        return -1; // Indicate not found or error
    }
}