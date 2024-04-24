package by.javaguru.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static String url = "db.url";
    private static String user = "db.username";
    private static String password = "db.password";

    public static Connection openConnection() {
        try {
            Connection connection = DriverManager.getConnection(
                    PropertiesUtil.get(url),
                    PropertiesUtil.get(user),
                    PropertiesUtil.get(password));
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
