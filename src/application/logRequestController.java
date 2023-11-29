package application;
import java.sql.Connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
public class logRequestController  {

    @FXML
    private ChoiceBox<String> opt;

    @FXML
    private TextField desc;
    

    @FXML
    private void submitRequest(ActionEvent event) throws SQLException {
    	String Description =desc.getText();
    	String choice=opt.getValue();
    //query run krein gey yaha par 
    	
    	DbThings d=new DbThings();
    	
    	Connection connection=d.connect_to_mysql();
    	
    	 if (connection != null) {
             int assignedDepartment = 1; // Replace with the actual department ID

             // SQL insert query
             String insertQuery = "INSERT INTO servicerequest (status, serviceType, description, assignedDepartment) " +
                     "VALUES (?, ?, ?, ?)";
             
             try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                 preparedStatement.setString(1, "Pending"); // Status can be set to "Pending" or another appropriate value
                 preparedStatement.setString(2, choice);
                 preparedStatement.setString(3, Description);
                 preparedStatement.setInt(4, assignedDepartment);

                 // Execute the insert query
                 int rowsAffected = preparedStatement.executeUpdate();

                 if (rowsAffected > 0) {
                     System.out.println("Data inserted successfully!");
                     // You can add further logic here for success handling
                 } else {
                     System.out.println("Failed to insert data!");
                     // You can add error handling logic here
                 }
             }
         }
    	 }
             

    
    
    public void initialize() {
        // Add the options to the ChoiceBox
    	opt.getItems().addAll("Hardware Issue", "Software Issue", "Others");
  
    }


}
