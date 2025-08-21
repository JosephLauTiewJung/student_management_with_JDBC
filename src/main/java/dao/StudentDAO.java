package dao;

import DbHelper.DbHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    // This class is responsible for managing student data.
    // It will contain methods to add, update, delete, and retrieve student information.

    /**
     * Adds a new student to the database.
     * @param name The name of the student.
     * @param age The age of the student.
     * @param gender The gender of the student
     * @return true if the student was added successfully, false otherwise.
    */
    public boolean addStudent(String name, int age, String gender) {
        dto.Student student = new dto.Student(name, age, gender);
        Connection conn = DbHelper.getConnection();
        String statement = "insert into student values (?, ?, ?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(statement);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, gender);
            return pstmt.executeUpdate() > 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DbHelper.close(conn, null, null, pstmt);
        }
        return false;
    }

    /**
     * Updates the age of a student in the database.
     * @param name
     * @param age
     * @param gender
     * @return true if the age was updated successfully, false otherwise.
     */
    public boolean updateStudentAge(String name, int age, String gender) {
        Connection conn = DbHelper.getConnection();
        String statement = "update student set age = ? where name = ? AND gender = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(statement);
            pstmt.setInt(1, age);
            pstmt.setString(2, name);
            pstmt.setString(3, gender);
            return pstmt.executeUpdate() > 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DbHelper.close(conn, null, null, pstmt);
        }
        return false;
    }

    /**
     * Deletes a student from the database.
     * @param name
     * @param gender
     * @return true if the student was deleted successfully, false otherwise.
     */
    public boolean deleteStudent(String name, String gender) {
        Connection conn = DbHelper.getConnection();
        String statement = "delete from student where name = ? and gender = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(statement);
            pstmt.setString(1, name);
            pstmt.setString(2, gender);
            return pstmt.executeUpdate() > 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DbHelper.close(conn, null, null, pstmt);
        }
        return false;
    }
    public List<dto.Student> retrieveStudentByName(String name) {
        List<dto.Student> studentList = new ArrayList<>();
        Connection conn = DbHelper.getConnection();
        String statement = "select * from student where name = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(statement);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                dto.Student student = new dto.Student(rs.getString("name"), rs.getInt("age"), rs.getString("gender"));
                studentList.add(student);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DbHelper.close(conn, null, null, pstmt);
        }
        return studentList;
    }
    public List<dto.Student> retrieveStudent() {
        List<dto.Student> studentList = new ArrayList<>();
        Connection conn = DbHelper.getConnection();
        String statement = "select * from student";
        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(statement);
            while(rs.next()) {
                dto.Student student = new dto.Student(rs.getString("name"), rs.getInt("age"), rs.getString("gender"));
                studentList.add(student);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DbHelper.close(conn, stmt, null, null);
        }
        return studentList;
    }
}
