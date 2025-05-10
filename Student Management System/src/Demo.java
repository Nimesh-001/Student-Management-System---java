import java.sql.Connection;

public class Demo {
    public static void main(String[] args) {
        Dbconnector dbc = new Dbconnector();
        Connection conn = dbc.getConnection();

        if (conn != null) {
            System.out.println("Database connection established");

        }
        else {
            System.out.println("Database connection not established");
        }

    }
}
