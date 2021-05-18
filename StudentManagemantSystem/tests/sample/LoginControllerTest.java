package sample;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {

    private static Connection Conn;

    static DatabaseConnection databaseConnection = new DatabaseConnection();
    LoginController loginController = new LoginController();

    @BeforeAll
    public static void setUpClassLogin() throws SQLException {
        Conn = databaseConnection.getConnection();
    }

    @AfterAll
    public static void tearDownClassLogin() {
        if (Conn != null) {
            try {
                Conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ChangePasswordControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Test
    @DisplayName("Login with username and password")
    @Tag("Critical")
    public void testLoginUserAndPassEmpty() throws SQLException {
        System.out.println("Test Login with blank Username and Password");
        String user = "";
        String pass = "";
        boolean kq = loginController.validateLoginTest(user, pass);
        assertFalse(kq);
    }

    @Test
    @DisplayName("Login with username and password")
    @Tag("Critical")
    public void testLoginUserAndPass() throws SQLException {
        System.out.println("Test Login with Username and Empty Password");
        String user = "Admin";
        String pass = "";
        boolean kq = loginController.validateLoginTest(user, pass);
        assertFalse(kq);
    }

    @Test
    @DisplayName("Login with username and password")
    @Tag("Critical")
    public void testLoginUserAndPass0() throws SQLException {
        System.out.println("Test Login with correct Username and wrong Password");
        String user = "Admin";
        String pass = "afsd1";
        boolean kq = loginController.validateLoginTest(user, pass);
        assertFalse(kq);
    }

    @Test
    @DisplayName("Login with username and password")
    @Tag("Critical")
    public void testLoginUserAndPass2() throws SQLException {
        System.out.println("Test Login with Empty Username and has Password");
        String user = "";
        String pass = "123";
        boolean kq = loginController.validateLoginTest(user, pass);
        assertFalse(kq);
    }

    @Test
    @DisplayName("Login with username and password")
    @Tag("Critical")
    public void testLoginUserAndPass2_1() throws SQLException {
        System.out.println("Test Login with wrong Username and correct Password");
        String user = "asdfas";
        String pass = "123";
        boolean kq = loginController.validateLoginTest(user, pass);
        assertFalse(kq);
    }

    @Test
    @DisplayName("Login with username and password")
    @Tag("Critical")
    public void testLoginUserAndPass3() throws SQLException {
        System.out.println("Test Login with WRONG Username and has Password");
        String user = "afas";
        String pass = "afs123";
        boolean kq = loginController.validateLoginTest(user, pass);
        assertFalse(kq);
    }

    @Test
    @DisplayName("Login with username and password")
    @Tag("Critical")
    public void testLoginUserAndPass4() throws SQLException {
        System.out.println("Test Login with Correct Username and Password");
        String user = "Admin";
        String pass = "123";
        boolean rs = loginController.validateLoginTest(user, pass);
        assertTrue(rs);
    }
}