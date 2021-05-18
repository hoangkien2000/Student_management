package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class ChangePasswordController implements Initializable {

    @FXML
    private ImageView changePasswordImageView;

    @FXML
    private ImageView backImageView;

    @FXML
    private Button restartButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField userTextField;

    @FXML
    private Label currentPasswordTextField;

    @FXML
    private Label confirmNewPasswordTextField;

    @FXML
    private Label newPasswordTextField;

    @FXML
    private Label notifyLabel;

    @FXML
    private Label notifyLabel2;

    @FXML
    private PasswordField currentPasswordField;

    @FXML
    private PasswordField confirmNewPasswordField;

    @FXML
    private PasswordField newPasswordField;


    String query = null;
    static String newPass;
    DatabaseConnection databaseConnection = new DatabaseConnection();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    LoginController loginController = new LoginController();
    SettingController settingController = new SettingController();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File changePassFile = new File("Images/update.png");
        Image changePassImage = new Image(changePassFile.toURI().toString());
        changePasswordImageView.setImage(changePassImage);

        File backFile = new File("Images/back_icon.png");
        Image backImage = new Image(backFile.toURI().toString());
        backImageView.setImage(backImage);

        fillUser();
    }

    public void fillUser() {
        try {
            connection = databaseConnection.getConnection();
            query = "SELECT user_account.username FROM student_db.user_account WHERE username = \"" + loginController.userLogin + "\";";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String user = resultSet.getString("username");
                setTextUser(user);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            exception.getMessage();
        }
    }

    public void tableAllFillAndUpdatePassword() {
        connection = databaseConnection.getConnection();

        currentPasswordTextField.setText("");
        newPasswordTextField.setText("");
        confirmNewPasswordTextField.setText("");
        notifyLabel.setText("");
        notifyLabel2.setText("");

        String oldPass = currentPasswordField.getText();
        String newPass = newPasswordField.getText();
        String confirmPass = confirmNewPasswordField.getText();
        String textNotify = "";

        Alert alertSetting = new Alert(Alert.AlertType.ERROR);
        alertSetting.setHeaderText("Save Password!!!");
        alertSetting.setContentText("Please fill all data!");

        if (oldPass.isEmpty() && newPass.isEmpty() && confirmPass.isEmpty()){
            alertSetting.show();
        } else if (currentPasswordField.getText().isBlank()) {
            textNotify = "Please fill out this field!";
            currentPasswordTextField.setText(textNotify);
        } else if (newPasswordField.getText().isBlank()) {
            textNotify = "Please fill out this field!";
            newPasswordTextField.setText(textNotify);
        } else if (confirmNewPasswordField.getText().isBlank()) {
            textNotify = "Please fill out this field!";
            confirmNewPasswordTextField.setText(textNotify);
        } else {
            if (newPass.equals(confirmPass) && currentPasswordField.getText().equals(loginController.passLogin) && (loginController.passLogin.equals(newPasswordField.getText()) == false)) {
                changePassword();
            } else if (currentPasswordField.getText().equals(loginController.passLogin) == false) {
                notifyLabel2.setText("Current password incorrect!!!");
            } else if (newPass.equals(confirmPass) == false) {
                notifyLabel.setText("New Password don't match!!");
            } else if (loginController.passLogin.equals(newPasswordField.getText()) == true){
                notifyLabel.setText("Old and new password is not Duplicate");
            }
        }
    }

    public boolean tableAllFillAndUpdatePasswordTest(String oldPass, String newPass, String confirmPass, String passLogin) {
        boolean test = false;
        connection = databaseConnection.getConnection();

        String textNotify = "Please fill out this field!";
        String notify1 = "New Password don't match!!";
        String notify2 = "Current password incorrect!!!";
//
//        Alert alertSetting = new Alert(Alert.AlertType.ERROR);
//        alertSetting.setHeaderText("Save Password!!!");
//        alertSetting.setContentText("Please fill all data!");

        if (oldPass.isEmpty() && newPass.isEmpty() && confirmPass.isEmpty()){
//            alertSetting.show();
        } else if (oldPass.isBlank()) {
//            currentPasswordTextField.setText(textNotify);
        } else if (newPass.isBlank()) {
            newPasswordTextField.setText(textNotify);
        } else if (confirmPass.isBlank()) {
            confirmNewPasswordTextField.setText(textNotify);
        } else {
            if ((newPass.equals(confirmPass) && oldPass.equals(passLogin)) && (passLogin.equals(newPass) == false)) {
                changePassword();
                test = true;
            } else if (oldPass.equals(loginController.passLogin) == false) {
//                notifyLabel2.setText(notify2);
            } else if (newPass.equals(confirmPass) == false) {
                notifyLabel.setText(notify1);
            } else if (loginController.passLogin.equals(newPass) == true){
                notifyLabel.setText(notify1);
            }
        }
        return test;
    }

    public void changePassword() {
        try {
            connection = databaseConnection.getConnection();
            String oldPass = currentPasswordField.getText();
            if (newPasswordField.getText().equals(confirmNewPasswordField.getText())) {
                newPass = confirmNewPasswordField.getText();
            }

            String query = "UPDATE student_db.user_account SET password = \"" + newPass + "\" WHERE username = \"" + loginController.userLogin +"\";";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();

            Alert alertSucces = new Alert(Alert.AlertType.CONFIRMATION);
            alertSucces.setHeaderText("Save Information Password");
            alertSucces.setContentText("Change password success!!!\n ==============> RESTART NOW!!!");
            ButtonType buttonTypeOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);

            alertSucces.getButtonTypes().setAll(buttonTypeOK);
            Optional<ButtonType> resultAlert = alertSucces.showAndWait();

            Stage stageSave = (Stage) saveButton.getScene().getWindow();
            if (resultAlert.get() == buttonTypeOK) {
                restartChangePass();
            } else {
                stageSave.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean changePasswordTest(String currentPass, String passLogin, String newPass, String confirmPass, String userLogin) {
        boolean test = false;
        try {
            connection = databaseConnection.getConnection();
            if ((newPass.equals(confirmPass) && currentPass.equals(passLogin)) && (currentPass.equals(confirmPass) == false)) {
                query = "UPDATE student_db.user_account SET password = \"" + newPass + "\" WHERE username = \"" + userLogin +"\";";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.execute();
                test = true;
            } else {
                return false;
            }

//            Alert alertSucces = new Alert(Alert.AlertType.CONFIRMATION);
//            alertSucces.setHeaderText("Save Information Password");
//            alertSucces.setContentText("Change password success!!!\n ==============> RESTART NOW!!!");
//            ButtonType buttonTypeOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
//
//            alertSucces.getButtonTypes().setAll(buttonTypeOK);
//            Optional<ButtonType> resultAlert = alertSucces.showAndWait();
//
//            Stage stageSave = (Stage) saveButton.getScene().getWindow();
//            if (resultAlert.get() == buttonTypeOK) {
//                restartChangePass();
//            } else {
//                stageSave.show();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return test;
    }

    public void setTextUser(String user) {
        userTextField.setText(user);
    }

    public void restartWhenNotChangePass() {

        Alert alertRestart = new Alert(Alert.AlertType.WARNING);
        alertRestart.setHeaderText("Restart Program!!!");
        alertRestart.setContentText("Are you sure about that????\n ==============> RESTART NOW!!!");
        ButtonType buttonTypeOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alertRestart.getButtonTypes().setAll(buttonTypeOK, buttonTypeCancel);
        Optional<ButtonType> resultAlert = alertRestart.showAndWait();

        Stage stageSave = (Stage) saveButton.getScene().getWindow();
        if (resultAlert.get() == buttonTypeOK) {
            restartChangePass();
        } else {
            stageSave.show();
        }

    }

    public void restartChangePass() {
        Stage stageSetting = (Stage) restartButton.getScene().getWindow();
        stageSetting.close();
        settingController.closeForChangePass();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));

        try {
            loader.load();
        } catch (Exception exception){
            exception.getMessage();
        }

        LoginController loginController = loader.getController();
        Parent parent = loader.getRoot();
        Stage stage = new Stage();
        Scene sceneEdit = new Scene(parent);
        sceneEdit.getStylesheets().add("/css/style.css");
        stage.setScene(sceneEdit);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    public void backChangeSetting() {
        Stage stageBack = (Stage) backButton.getScene().getWindow();
        stageBack.close();
    }
}
