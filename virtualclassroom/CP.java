package virtualclassroom;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CP {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Virtual_Classroom";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Korvi@07_";

   

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

	public static Connection createConnection() {
		Connection connection = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Create the database connection
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
		
	}

	
}
