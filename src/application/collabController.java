package application;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class collabController {

    @FXML
    private ChoiceBox<String> srv;
    @FXML
    private TextArea cnote;
    @FXML
    private TextField idUser; 

    // Initialize method to load service request IDs
    @FXML
    public void initialize() {
        try (Connection conn = DbThings.connect_to_mysql();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT requestId FROM ServiceRequest")) {
            while (rs.next()) {
                srv.getItems().add(String.valueOf(rs.getInt("requestId")));
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception properly
        }
    }

    // Event handler for the Collaborate button
    @FXML
    public void onCollaborateButtonClick() {
        String selectedRequestId = srv.getValue();
        String collabNote = cnote.getText();
        String personId = idUser.getText();

        try (Connection conn = DbThings.connect_to_mysql();
             Statement stmt = conn.createStatement()) {
            String sql = "INSERT INTO Collaboration (requestId, personId, collabNote) VALUES (" 
                          + selectedRequestId + ", " + personId + ", '" + collabNote + "')";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception properly
        }
    }
}
