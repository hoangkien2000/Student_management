package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingController implements Initializable {
    @FXML
    private ImageView settingImageView;

    @FXML
    public Button closeButton;

    @FXML
    public static Button close;

    public static Button getClose() {
        return close;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File settingFile = new File("Images/settings.png");
        Image settingImage = new Image(settingFile.toURI().toString());
        settingImageView.setImage(settingImage);
        close = closeButton;
    }


    public void getChangePassword (ActionEvent event) {
        createFormChangePass();
    }

    public void createFormChangePass() {
        try {
            Parent rootChange = FXMLLoader.load(getClass().getResource("changepassword.fxml"));
            Stage stageClassroom = new Stage();
            stageClassroom.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(rootChange, 610, 710);
            scene.getStylesheets().add("css/style.css");
            stageClassroom.setScene(scene);
            stageClassroom.show();
        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public void closeSetting() {
        closeForChangePass();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("home.fxml"));

        try {
            loader.load();
        } catch (Exception exception){
            exception.getMessage();
        }

        HomeController homeController = loader.getController();
        Parent parent = loader.getRoot();
        Stage stage = new Stage();
        Scene sceneEdit = new Scene(parent);
        sceneEdit.getStylesheets().add("/css/style.css");
        stage.setScene(sceneEdit);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();

    }

    public void closeForChangePass() {
        Stage stageForChangePass = (Stage) close.getScene().getWindow();
        stageForChangePass.close();
    }
}
