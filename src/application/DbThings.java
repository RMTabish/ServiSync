package application;

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

public class DbThings {
	
	//yaha db sa connect hona ha or user data retrienve karna ha 
	//phir login complete karna ha 
	//oskey bad 3 log request useacse implement karna ha 
static	Connection connection;
	public static  Connection connect_to_mysql()
	{
	///make db object and see if we connecting to the databasse
	String url = "jdbc:mysql://localhost:3306/servisync";
    String username = "root";
    String password = "12345678";
    try {
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to the database");
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Failed to connect to the database");
    }
   return connection ;
   
	
	}
	
	
	 public static boolean authenticateUser(String username, String password) {
	        try (Connection connection = connect_to_mysql()) {
	            String sql = "SELECT * FROM employee WHERE userName = ? AND password = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);
	            System.out.println("user found");
	            ResultSet resultSet = preparedStatement.executeQuery();
	            return resultSet.next(); // If a row is found, the user is authenticated.
	        } catch (SQLException e) {
	            e.printStackTrace();

	            System.err.println("user not found");
	            return false;
	        }
	    }
}
