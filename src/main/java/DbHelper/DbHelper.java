package DbHelper;
import java.sql.*;

public class DbHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/student";
    private static final String USER = "root";
    private static final String PASSWORD = "Ltj321286+";

    /**
     * Establishes a connection to the database.
     * @return Connection object is the connection to the database.
     *         Returns null if the connection fails.

     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(conn == null ? "Connection failed!" : "Connection successful!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * Closes the database resources.
     * @param conn The Connection object to be closed.
     * @param stmt The Statement object to be closed.
     * @param rs The ResultSet object to be closed.
     * @param pstmt The PreparedStatement object to be closed.
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs, PreparedStatement pstmt) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (pstmt != null && !pstmt.isClosed()) {
                pstmt.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
