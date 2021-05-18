package sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {
    private static Connection connection;
    DatabaseConnection databaseConnection = new DatabaseConnection();
    StudentController studentController = new StudentController();
    @BeforeEach
    void setUp() {
        connection = databaseConnection.getConnection();
    }

    @AfterEach
    void tearDown() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Test
    public void testDeleteStudent() throws SQLException {
        System.out.println("Delete student with id have in Class");
        int id = 1;
        boolean rs = studentController.deleteStudentTest(id);
        assertTrue(rs);
    }

    @Test
    public void testDeleteStudent2() throws SQLException {
        System.out.println("Delete student with id haven't in Class");
        int id = 2;
        boolean rs = studentController.deleteStudentTest(id);
        assertFalse(rs);
    }
    @Test
    public void testLoadTableView() {
        System.out.println("Creat form AddStudent");
        boolean rs = studentController.refreshTableViewTest();
        assertTrue(rs);
    }
}