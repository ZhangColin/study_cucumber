package nickbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnTools {
    private static String dirverClassName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost/bank";
    private static String user = "teller";
    private static String password = "password";

    public static Connection makeConnection() {
        Connection conn = null;
        try {
            Class.forName(dirverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
