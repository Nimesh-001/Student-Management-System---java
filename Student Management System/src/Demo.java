import java.sql.Connection;

public class Demo {
    public static void main(String[] args) {
        Dbconnector dc = new Dbconnector();
        Connection conn = dc.getConnection();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }




        if (conn != null) {
            System.out.println("Database connection established");

        }
        else {
            System.out.println("Database connection not established");
        }

    }
}
