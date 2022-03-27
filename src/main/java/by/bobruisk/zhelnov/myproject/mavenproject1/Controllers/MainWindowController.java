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
import javafx.scene.control.Label;


public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label formFillerLabel;

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;
    
        @FXML
    private void switchToSignUp() throws IOException {
        App.setRoot("signUp");
    }
            @FXML
    private void switchToSignIn() throws IOException {
        App.setRoot("signIn");
    	
    }

    @FXML
    void initialize() {
        assert formFillerLabel != null : "fx:id=\"formFillerLabel\" was not injected: check your FXML file 'mainWindow.fxml'.";
        assert signInButton != null : "fx:id=\"signInButton\" was not injected: check your FXML file 'mainWindow.fxml'.";
        assert signUpButton != null : "fx:id=\"signUpButton\" was not injected: check your FXML file 'mainWindow.fxml'.";

    }

}
