package sample;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class ChangePasswordControllerTest {

    private static Connection Conn;

    static DatabaseConnection databaseConnection = new DatabaseConnection();
    ChangePasswordController changePasswordController = new ChangePasswordController();

    @BeforeEach
    void setUp() {
        Conn = databaseConnection.getConnection();
    }

    @AfterEach
    void tearDown() {
        if (Conn != null) {
            try {
                Conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Test
    @DisplayName("LoadTableView")
    @Tag("Critical")
    public void testLoadTableView() {
        System.out.println("LoadTableView for change Pass without wrong pass");
        String oldPass = "";
        String newPass = "";
        String confirmNewPass = "";
        String passLogin = "";
        boolean rs = changePasswordController.tableAllFillAndUpdatePasswordTest(oldPass, newPass, confirmNewPass, passLogin);
        assertFalse(rs);
    }

    @Test
    @DisplayName("LoadTableView")
    @Tag("Critical")
    public void testLoadTableView1() {
        System.out.println("LoadTableView for change Pass");
        String passLogin = "123";
        String currentPass = "123";
        String newPass = "123";
        String confirmNewPass = "1234";
        boolean rs = changePasswordController.tableAllFillAndUpdatePasswordTest(currentPass, newPass, confirmNewPass, passLogin);
        assertFalse(rs);
    }


    @Test
    @DisplayName("LoadTableView")
    @Tag("Critical")
    public void testLoadTableView2() {
        System.out.println("LoadTableView for change Pass with passLogin and current pass is not match");
        String passLogin = "123";
        String currentPass = "123a";
        String newPass = "abc";
        String confirmNewPass = "abc";
        boolean rs = changePasswordController.tableAllFillAndUpdatePasswordTest(currentPass, newPass, confirmNewPass, passLogin);
        assertFalse(rs);
    }

    @Test
    @DisplayName("LoadTableView")
    @Tag("Critical")
    public void testLoadTableView3() {
        System.out.println("LoadTableView for change Pass with passLogin true but current pass is empty");
        String passLogin = "123";
        String currentPass = "";
        String newPass = "a";
        String confirmNewPass = "a";
        boolean rs = changePasswordController.tableAllFillAndUpdatePasswordTest(currentPass, newPass, confirmNewPass, passLogin);
        assertFalse(rs);
    }

    @Test
    @DisplayName("LoadTableView")
    @Tag("Critical")
    public void testLoadTableView4() {
        System.out.println("LoadTableView for change Pass with passLogin is empty and current pass is true");
        String passLogin = "";
        String currentPass = "123";
        String newPass = "a";
        String confirmNewPass = "a";
        boolean rs = changePasswordController.tableAllFillAndUpdatePasswordTest(currentPass, newPass, confirmNewPass, passLogin);
        assertFalse(rs);
    }

    @Test
    @DisplayName("LoadTableView")
    @Tag("Critical")
    public void testLoadTableView5() {
        System.out.println("LoadTableView for change Pass with all info true");
        String passLogin = "123";
        String currentPass = "123";
        String newPass = "a";
        String confirmNewPass = "a";
        boolean rs = changePasswordController.tableAllFillAndUpdatePasswordTest(currentPass, newPass, confirmNewPass, passLogin);
        assertTrue(rs);
    }

    @Test
    @DisplayName("Change Password Test")
    @Tag("Critical")
    public void testChangePassword() {
        System.out.println("Module test for change pass *current == passlogin* && *new pass == confirm pass*");
        String userLogin = "Admin";
        String currentPass = "123";
        String passLogin = "123";
        String newpass = "abc";
        String confirmPass = "abc";
        boolean rs = changePasswordController.changePasswordTest(currentPass, passLogin, newpass, confirmPass, userLogin);
        assertTrue(rs);
    }

    @Test
    @DisplayName("Change Password Test")
    @Tag("Critical")
    public void testChangePassword2() {
        System.out.println("Module test for change pass *current !== passlogin* && *new pass == confirm pass*");
        String userLogin = "Admin";
        String currentPass = "123";
        String passLogin = "abc";
        String newpass = "1234";
        String confirmPass = "1234";
        boolean rs = changePasswordController.changePasswordTest(currentPass, passLogin, newpass, confirmPass, userLogin);
        assertFalse(rs);
    }

    @Test
    @DisplayName("Change Password Test")
    @Tag("Critical")
    public void testChangePassword3() {
        System.out.println("Module test for change pass *current == passlogin* && *new pass !== confirm pass*");
        String userLogin = "Admin";
        String currentPass = "abc";
        String passLogin = "abc";
        String newpass = "14";
        String confirmPass = "1234";
        boolean rs = changePasswordController.changePasswordTest(currentPass, passLogin, newpass, confirmPass, userLogin);
        assertFalse(rs);
    }

    @Test
    @DisplayName("Change Password Test")
    @Tag("Critical")
    public void testChangePassword4() {
        System.out.println("Module test for change pass *current == passlogin* && *new pass !== confirm pass* && currentpass == confirmpass");
        String userLogin = "Admin";
        String currentPass = "1234";
        String passLogin = "1234";
        String newpass = "1234";
        String confirmPass = "1234";
        boolean rs = changePasswordController.changePasswordTest(currentPass, passLogin, newpass, confirmPass, userLogin);
        assertFalse(rs);
    }
}