package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TrackRequestController {
  
    
    @FXML
    private TextField sts;

    @FXML
    private TextField typ;

    @FXML
    private TextArea desc;

    @FXML
    private TextField dept;


	  @FXML
	  private TextField TRid;
	  
    @FXML
    public void initialize() {
        // Add initialization code here, if needed.
    }
    
    

    // Add a method to handle the retrieval of data based on the entered ID.
    public void retrieveData() {
    	

    	try {
    		

    		    String id=TRid.getText();
            Connection connection = DbThings.connect_to_mysql();
            
            // Prepare the SQL query to retrieve data based on serviceRequestId
            String query = "SELECT * FROM ServiceRequest WHERE requestId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            
          
            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();
            
            // Process the result set
            if (resultSet.next()) {
                String status = resultSet.getString("status");
                String type = resultSet.getString("serviceType");
                String description = resultSet.getString("description");
                int assignedDeptId = resultSet.getInt("assignedDepartment");
            
                String AS=Integer.toString(assignedDeptId);
                sts.setText(status);
                typ.setText(type);
                desc.setText(description);
                dept.setText(AS);
                // You can use the retrieved data as needed
                System.out.println("Status: " + status);
                System.out.println("Type: " + type);
                System.out.println("Description: " + description);
                System.out.println("Assigned Department ID: " + assignedDeptId);
            } else {
                System.out.println("Service request with ID " + id + " not found.");
            }
            
            // Close resources
            resultSet.close();
            preparedStatement.close();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Update the UI with the retrieved data.
        
    }
    
    @FXML
    void back(ActionEvent event) {
        try {
            // Load the home page (home.fxml)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
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
