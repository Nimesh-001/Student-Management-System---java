import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnector {


    public Dbconnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to database...");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load JDBC driver. " + e.getMessage());
        }
    }

    public Connection getConnection() {
        Connection conn = null;

        String url = "jdbc:mysql://localhost:3306/tecmis_db";
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
