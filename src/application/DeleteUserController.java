package application;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserController {

    @FXML
    private TextField employeeIdField;


    // Method to delete employee data from the database
    public void deleteEmployee() {
        String sql = "DELETE FROM Employee WHERE employeeId = ?";

        try (Connection conn = DbThings.connect_to_mysql();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Assuming employee ID is an integer
            int employeeId = Integer.parseInt(employeeIdField.getText());
            pstmt.setInt(1, employeeId);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                // Handle case where no rows were affected, i.e., employee ID not found
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exception properly in a real-world application
        } catch (NumberFormatException e) {
            // Handle case where input is not a valid integer
        }
    }
}

