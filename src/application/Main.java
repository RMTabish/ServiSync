package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	static Connection connection ;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
	DbThings db=new DbThings();
	connection=db.connect_to_mysql();
	boolean yes;
	yes=db.authenticateUser("johndoe", "hashed_password");
	        
	        
	        
			Parent root=FXMLLoader.load(getClass().getResource("AssignResources.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
