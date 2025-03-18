import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/FormDB";
    private static final String USER = "root"; // Thay bang user của ban
    private static final String PASSWORD = ""; // Thay bang mat khau của ban

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
