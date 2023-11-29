package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
	        boolean isAuthenticated=DbThings.authenticateUser(username, password);
	        if (isAuthenticated) {
	            // Authentication successful, navigate to the home page or another page
	            // You can use FXMLLoader to load the home page or change the scene accordingly.
	            // Example: Load the home page using FXMLLoader
	            // FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
	            // Parent root = loader.load();
	            // Scene scene = new Scene(root);
	            // Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	            // stage.setScene(scene);
	        	 System.out.println("hogiya login");
	        } else {
	            // Authentication failed, show an error message to the user
	          System.out.println("ni hoa login");
	        }
	        

	    }

}
