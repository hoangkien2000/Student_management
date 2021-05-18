package sample;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AddStudentControllerTest {

    private static Connection connection;
    DatabaseConnection databaseConnection = new DatabaseConnection();

    AddStudentController addStudentController = new AddStudentController();

    @BeforeEach
    void setUp() {
        connection = databaseConnection.getConnection();
    }

    @AfterEach
    void tearDown() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

    @Test
    @DisplayName("Test for AddStudentController")
    @Tag("Criticial")
    public void TestForfillComboBoxChanged() {
        System.out.println("Test for Fill Combobox Change");
        boolean rs = addStudentController.fillComboBoxChangedTest();
        assertTrue(rs);
    }

}