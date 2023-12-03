package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class homeController {
    @FXML
    private Button logServiceRequestButton;

    @FXML
    private Button collaborateOnRequestButton;

    @FXML
    private Button trackServiceRequestButton;

    @FXML
    private Button logOutButton;

    @FXML
    private ImageView logoImageView;

    // Action for the "Log Service Request" button
    @FXML
    private void handleLogServiceRequestButtonAction(ActionEvent event) {
    	loadPage(event,"logRequest.fxml");
    }

    // Action for the "Collaborate on Request" button
    @FXML
    private void handleCollaborateOnRequestButtonAction(ActionEvent event) {
    	loadPage(event,"Collab.fxml");
    }

    // Action for the "Track Service Request" button
    @FXML
    private void handleTrackServiceRequestButtonAction(ActionEvent event) {
    	loadPage(event,"TrackRequest.fxml");
    }

    // Action for the "Log Out" button
    @FXML
    private void handleLogOutButtonAction(ActionEvent event) {
    	loadPage(event,"LoginUser.fxml");
    }
    
    void loadPage(ActionEvent event, String name) {
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
