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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignInController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label formFillerLabel;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private CheckBox remeberMeCheckBox;

    @FXML
    private Button singInButton;
    
    @FXML
    private void switchToFillWindow() throws IOException {
        App.setRoot("fillWindow");
    }

    @FXML
    void initialize() {
        assert formFillerLabel != null : "fx:id=\"formFillerLabel\" was not injected: check your FXML file 'signIN.fxml'.";
        assert loginField != null : "fx:id=\"loginField\" was not injected: check your FXML file 'signIN.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'signIN.fxml'.";
        assert remeberMeCheckBox != null : "fx:id=\"remeberMeCheckBox\" was not injected: check your FXML file 'signIN.fxml'.";
        assert singInButton != null : "fx:id=\"singInButton\" was not injected: check your FXML file 'signIN.fxml'.";

    }

}
