package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static final String URL = "jdbc:mysql://localhost:3306/restaurant_db";
    static final String USER = "root";
    static final String PASS = "Gaganm@9075"; // change if needed
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static Connection con;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (con == null || con.isClosed()) {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASS);
        }
        return con;
    }

    public static void closeConnection() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
}
