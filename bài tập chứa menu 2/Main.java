import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField textField = new TextField();
        Button saveButton = new Button("Luu vào Database");

        saveButton.setOnAction(e -> saveToDatabase(textField.getText()));

        VBox vbox = new VBox(10, textField, saveButton);
        vbox.setPadding(new Insets(20));

        Scene scene = new Scene(vbox, 300, 150);
        primaryStage.setTitle("Luu du lieu vao Database");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void saveToDatabase(String text) {
        String sql = "INSERT INTO UserInput (input_text) VALUES (?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, text);
            pstmt.executeUpdate();
            System.out.println("Du lieu đa duoc luu!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
