package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AdminHomeController {


    @FXML
    private Button assignServiceRequestButton;

    @FXML
    private Button addEmployeeButton;

    @FXML
    private Button allocateResourcesButton;

    @FXML
    private Button deleteEmployeeButton;

    // Function for the "Assign Service Request" button
    @FXML
    private void handleAssignServiceRequestButtonAction(ActionEvent event) {
       loadHomePage(event,"AssignSR.fxml");
    }

    // Function for the "Add Employee" button
    @FXML
    private void handleAddEmployeeButtonAction(ActionEvent event) {
        loadHomePage(event,"AddEmployee.fxml");
    }

    // Function for the "Allocate Resources" button
    @FXML
    private void handleAllocateResourcesButtonAction(ActionEvent event) {
        loadHomePage(event,"AssignResources.fxml");
    }

    // Function for the "Delete Employee" button
    @FXML
    private void handleDeleteEmployeeButtonAction(ActionEvent event) {
        loadHomePage(event,"DeleteUser.fxml");
    }
    
    
    void loadHomePage(ActionEvent event, String name) {
        try {
            // Load the home page (home.fxml)
            FXMLLoader loader = new FXMLLoader(getClass().getResource(name));
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

