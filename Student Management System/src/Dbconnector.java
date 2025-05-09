import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnector {
    public Connection getConnection() {
        Connection conn = null;

        String url = "jdbc:mysql://localhost:3306/tecmis";
        String user = "root";
        String password = "1234";

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Database connection successful");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
