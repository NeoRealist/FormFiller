/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package by.bobruisk.zhelnov.myproject.mavenproject1.Controllers;

/**
 *
 * @author Anton
 */
import by.bobruisk.zhelnov.myproject.mavenproject1.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField departmentTextField;

    @FXML
    private TextField emailField;

    @FXML
    private Label formFillerLabel;

    @FXML
    private Text loginText;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField organizationTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField passwordRepeatField;

    @FXML
    private TextField patronymicTextField;

    @FXML
    private TextField specialityTextField;

    @FXML
    private TextField surnameTextField;
    
    @FXML
    private void switchToMainWindow() throws IOException {
        App.setRoot("mainWindow");
    }

    @FXML
    void initialize() {
        assert departmentTextField != null : "fx:id=\"departmentTextField\" was not injected: check your FXML file 'signUP.fxml'.";
        assert emailField != null : "fx:id=\"emailField\" was not injected: check your FXML file 'signUP.fxml'.";
        assert formFillerLabel != null : "fx:id=\"formFillerLabel\" was not injected: check your FXML file 'signUP.fxml'.";
        assert loginText != null : "fx:id=\"loginText\" was not injected: check your FXML file 'signUP.fxml'.";
        assert nameTextField != null : "fx:id=\"nameTextField\" was not injected: check your FXML file 'signUP.fxml'.";
        assert organizationTextField != null : "fx:id=\"organizationTextField\" was not injected: check your FXML file 'signUP.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'signUP.fxml'.";
        assert passwordRepeatField != null : "fx:id=\"passwordRepeatField\" was not injected: check your FXML file 'signUP.fxml'.";
        assert patronymicTextField != null : "fx:id=\"patronymicTextField\" was not injected: check your FXML file 'signUP.fxml'.";
        assert specialityTextField != null : "fx:id=\"specialityTextField\" was not injected: check your FXML file 'signUP.fxml'.";
        assert surnameTextField != null : "fx:id=\"surnameTextField\" was not injected: check your FXML file 'signUP.fxml'.";

    }

}
