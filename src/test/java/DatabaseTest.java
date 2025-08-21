import DbHelper.DbHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DatabaseTest {

    @Test
    public void testConnection()  {
        Connection conn = DbHelper.getConnection();
        Assert.assertNotNull(conn);
    }

    @Test
    public void testTableExist() throws SQLException, ClassNotFoundException {
        Connection conn = DbHelper.getConnection();
        dao.StudentDAO studentDAO = new dao.StudentDAO();
        List<dto.Student> studentList= studentDAO.retrieveStudent();
        Assert.assertNotNull(studentList);
    }
    @Test
    public void testQueryStudent() throws SQLException, ClassNotFoundException {
        Connection conn = DbHelper.getConnection();
        dao.StudentDAO studentDAO = new dao.StudentDAO();
        List<dto.Student> studentList = studentDAO.retrieveStudent();
        Assert.assertNotNull(studentList);
    }
    @After
    public void tearDown() throws SQLException, ClassNotFoundException {
        Connection conn = DbHelper.getConnection();
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}
