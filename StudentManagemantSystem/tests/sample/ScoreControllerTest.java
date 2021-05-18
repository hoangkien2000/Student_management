package sample;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class ScoreControllerTest {

    private static Connection connection;
    static DatabaseConnection databaseConnection = new DatabaseConnection();
    ScoreController scoreController = new ScoreController();

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
                Logger.getLogger(ScoreControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Test
    @DisplayName("Test fill combobox Class")
    @Tag("Critical")
    public void TestFillComboboxClass() {
        System.out.println("Test for Fill ComboBox Class");
        boolean test = scoreController.fillComboboxClassTest();
        assertTrue(test);
    }

    @Test
    @DisplayName("Test fill combobox Exam")
    @Tag("Critical")
    public void TestFillComboboxExam() {
        System.out.println("Test for Fill ComboBox Exam");
        boolean test = scoreController.fillComboboxExamTest();
        assertTrue(test);
    }

    @Test
    @DisplayName("Test fill combobox Course")
    @Tag("Critical")
    public void TestFillComboboxCourse() {
        System.out.println("Test for Fill ComboBox Course");
        boolean test = scoreController.fillComboboxCourseTest();
        assertTrue(test);
    }

    @Test
    @DisplayName("Test refresh Classroom TableView")
    @Tag("Critical")
    public void TestRefreshClassroomTableView() {
        System.out.println("Test for refresh ClassroomTableView");
        String classroom = "DH18CS81";
        String examType = "Thi Cuối Kì";
        String course = "Lập trình hướng đối tượng";
        boolean test = scoreController.refreshClassroomTableViewTest(classroom, examType, course);
        assertTrue(test);
    }

    @Test
    @DisplayName("Test refresh Classroom TableView")
    @Tag("Critical")
    public void TestRefreshClassroomTableView1() {
        System.out.println("Test for refresh ClassroomTableView with Classroom and course are empty");
        String classroom = "";
        String examType = "";
        String course = "";
        boolean test = scoreController.refreshClassroomTableViewTest(classroom, examType, course);
        assertFalse(test);
    }

    @Test
    @DisplayName("Test refresh Classroom TableView")
    @Tag("Critical")
    public void TestRefreshClassroomTableView2() {
        System.out.println("Test for refresh ClassroomTableView with classroom is empty");
        String classroom = "";
        String examType = "Thi Cuối Kì";
        String course = "Lập trình hướng đối tượng";
        boolean test = scoreController.refreshClassroomTableViewTest(classroom, examType, course);
        assertFalse(test);
    }

    @Test
    @DisplayName("Test refresh Classroom TableView")
    @Tag("Critical")
    public void TestRefreshClassroomTableView3() {
        System.out.println("Test for refresh ClassroomTableView with ExamType is empty");
        String classroom = "DH18CS81";
        String examType = "";
        String course = "Lập trình hướng đối tượng";
        boolean test = scoreController.refreshClassroomTableViewTest(classroom, examType, course);
        assertFalse(test);
    }

    @Test
    @DisplayName("Test refresh Classroom TableView")
    @Tag("Critical")
    public void TestRefreshClassroomTableView4() {
        System.out.println("Test for refresh ClassroomTableView with Course is empty");
        String classroom = "DH18CS81";
        String examType = "Thi Cuối Kì";
        String course = "";
        boolean test = scoreController.refreshClassroomTableViewTest(classroom, examType, course);
        assertFalse(test);
    }

    @Test
    @DisplayName("Test refresh Classroom TableView")
    @Tag("Critical")
    public void TestRefreshClassroomTableView5() {
        System.out.println("Test for refresh ClassroomTableView with Classroom and ExamType are empty");
        String classroom = "";
        String examType = "";
        String course = "Lập trình hướng đối tượng";
        boolean test = scoreController.refreshClassroomTableViewTest(classroom, examType, course);
        assertFalse(test);
    }

    @Test
    @DisplayName("Test refresh Classroom TableView")
    @Tag("Critical")
    public void TestRefreshClassroomTableView6() {
        System.out.println("Test for refresh ClassroomTableView with Classroom and course are empty");
        String classroom = "";
        String examType = "Thi Cuối Kì";
        String course = "";
        boolean test = scoreController.refreshClassroomTableViewTest(classroom, examType, course);
        assertFalse(test);
    }

    @Test
    @DisplayName("Test refresh Classroom TableView")
    @Tag("Critical")
    public void TestRefreshClassroomTableView7() {
        System.out.println("Test for refresh ClassroomTableView with Examtype and course are empty");
        String classroom = "DH18CS81";
        String examType = "";
        String course = "";
        boolean test = scoreController.refreshClassroomTableViewTest(classroom, examType, course);
        assertFalse(test);
    }

    @Test
    @DisplayName("Test UpdateScore")
    @Tag("Critical")
    public void TestUpdateScore() {
        System.out.println("Test for UpdateScore");
        String score = "2";
        String studentId = "25";
        String courseId = "1";
        String examId = "1";
        boolean test = scoreController.updateScoreTest(score, studentId, courseId, examId);
        assertTrue(test);
    }

}