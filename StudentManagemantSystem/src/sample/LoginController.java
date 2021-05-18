package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {


    @FXML
    private Button cancelButton;

    @FXML
    private Button loginButton;

    @FXML
    private CheckBox showpassCheckbox;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private Label forgotPasswordLabel;

    @FXML
    private ImageView brandingImageView;

    @FXML
    private ImageView lockImageView;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Tooltip tooltipPassword;

    @FXML
    private Tooltip ttPassword;

    @FXML
    private PasswordField passwordPasswordField;

    public static String userLogin = null;
    public static String passLogin = null;
    HomeController homeController = new HomeController();
    Duration duration1 = null;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("Images/branded.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File lockFile = new File("Images/lock_login.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);

        this.togglevisiblePassword(null);
        duration1 = new Duration(10000);
        tooltipPassword.setText("Password empty");
    }

    public void loginButtonOnAction(ActionEvent event) {
        if (usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false) {
            validateLogin();
//            validateLoginTest(usernameTextField.getText(), passwordPasswordField.getText());
        } else if (usernameTextField.getText().isBlank() == true && passwordPasswordField.getText().isBlank() == false) {
            loginMessageLabel.setText("Please enter username!");
        } else if (usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == true) {
            loginMessageLabel.setText("Please enter password!");
        } else if (usernameTextField.getText().isBlank() == true && passwordPasswordField.getText().isBlank() == true) {
            loginMessageLabel.setText("Please enter username and password!");
        }
    }

    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin() {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();

        String verifyLogin = "SELECT user_account.username, user_account.password FROM student_db.user_account WHERE user_account_id = \"1\";";
        try {
            Statement statement = connectionDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next()) {
                String user = queryResult.getString("username");
                userLogin = user;
                String password = queryResult.getString("password");
                passLogin = password;
                if (usernameTextField.getText().equals(user) && passwordPasswordField.getText().equals(password)) {
                    createHomeManagementForm();
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    stage.hide();
                }
                if (!(usernameTextField.getText().equals(user)) && passwordPasswordField.getText().equals(password)) {
                    loginMessageLabel.setText("User does not exist!");
                }
                if ((usernameTextField.getText().equals(user) && passwordPasswordField.getText().equals(password) == false)) {
                    loginMessageLabel.setText("Wrong password!");
                }
                if (usernameTextField.getText().equals(user) == false && passwordPasswordField.getText().equals(password) == false) {
                    loginMessageLabel.setText("User does not exist!");
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
            e.getCause();
        }
    }

    public boolean validateLoginTest(String userEnter, String passwordEnter) {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();
        boolean resultTest = false;

        String verifyLogin = "SELECT * FROM student_db.user_account WHERE user_account.username = \"" + userEnter + "\" " +
                "AND user_account.password = \"" + passwordEnter + "\";";
        try {
            Statement statement = connectionDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next()) {
                resultTest = true;
//                String user = queryResult.getString("username");
//                String password = queryResult.getString("password");
//                if (userEnter.equals(user) && passwordEnter.equals(password)) {
//                    createHomeManagementForm();
//                    Stage stage = (Stage) loginButton.getScene().getWindow();
//                    stage.hide();
//                } else if (!(usernameTextField.getText().equals(user)) && passwordPasswordField.getText().equals(password)) {
//                    loginMessageLabel.setText("User does not exist!");
//                } else if (!(passwordPasswordField.getText().equals(password))) {
//                    loginMessageLabel.setText("Wrong password!");
//                } else if (!(usernameTextField.getText().equals(user)) && !(passwordPasswordField.getText().equals(password))) {
//                    loginMessageLabel.setText("Wrong username or password!");
//                }
            }
        } catch (Exception e) {
            e.getStackTrace();
            e.getCause();
        }
        return resultTest;
    }

    public void Key_Handle_Login(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            if (usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false) {
                validateLogin();
//            validateLoginTest(usernameTextField.getText(), passwordPasswordField.getText());
            } else if (usernameTextField.getText().isBlank() == true && passwordPasswordField.getText().isBlank() == false) {
                loginMessageLabel.setText("Please enter username!");
            } else if (usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == true) {
                loginMessageLabel.setText("Please enter password!");
            } else if (usernameTextField.getText().isBlank() == true && passwordPasswordField.getText().isBlank() == true) {
                loginMessageLabel.setText("Please enter username and password!");
            }
        }
    }

    public void Key_Handle_Back(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ESCAPE)) {
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        }
    }

    public void createHomeManagementForm() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
            Stage stageHomeManagement = new Stage();
            stageHomeManagement.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(root, 1024, 615);
            scene.getStylesheets().add("css/style.css");
            stageHomeManagement.setScene(scene);
            stageHomeManagement.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void notifyForUpdateModules() {
        homeController.updatePageHome();
    }

    public void togglevisiblePassword(ActionEvent event) {
        if (showpassCheckbox.isSelected()) {
            tooltipPassword.setText(passwordPasswordField.getText());
            tooltipPassword.setShowDuration(duration1);
            tooltipPassword.getShowDuration();
        } else {
            tooltipPassword.setText("Password empty");
        }
    }
}
