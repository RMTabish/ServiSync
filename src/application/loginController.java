package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class loginController {
	
	 @FXML
	    private TextField admin_id;

	    @FXML
	    private TextField admin_password;

	    @FXML
	    private Button register_button2;
	    
	    @FXML
	    private void handleLoginButtonAction(ActionEvent event) {
	        String username = admin_id.getText();
	        String password = admin_password.getText();
	        boolean isAuthenticated = DbThings.authenticateUser(username, password);
	        
	        if (isAuthenticated) {
	            // Authentication successful, load the home page (home.fxml)
	        	loadHomePage(event,"Home.fxml");
	        } else {
	            // Authentication failed, show an error message to the user
	            System.out.println("Login failed for user");
	        }
	    }

	    @FXML
	    private void handleAdminLoginButtonAction(ActionEvent event) {
	        String username = admin_id.getText();
	        String password = admin_password.getText();
	        boolean isAuthenticated = DbThings.authenticateAdmin(username, password);

	        if (isAuthenticated) {
	            // Authentication successful, load the home page (home.fxml)
	        	loadHomePage(event,"AdminHome.fxml");
	        } else {
	            // Authentication failed, show an error message to the user
	            System.out.println("Login failed for admin");
	        }
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
