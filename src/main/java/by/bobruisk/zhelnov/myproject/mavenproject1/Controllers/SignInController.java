package by.bobruisk.zhelnov.myproject.mavenproject1.Controllers;

/**
 *
 * @author Anton
 */
import by.bobruisk.zhelnov.myproject.mavenproject1.App;
import by.bobruisk.zhelnov.myproject.mavenproject1.User;
import by.bobruisk.zhelnov.myproject.mavenproject1.Controllers.dbcontrollers.DatabaseHandler;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		String login = loginField.getText().trim();
		String password = passwordField.getText().trim();
		System.out.println("Email: " + login);
		System.out.println("Password: " + password);
		if (login.equals("") && password.equals("")) {
			System.out.println("Field is empty");
		} else {
    	signIn(login, password);
		}
        
    }

    @FXML
    void initialize() {
        assert formFillerLabel != null : "fx:id=\"formFillerLabel\" was not injected: check your FXML file 'signIN.fxml'.";
        assert loginField != null : "fx:id=\"loginField\" was not injected: check your FXML file 'signIN.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'signIN.fxml'.";
        assert remeberMeCheckBox != null : "fx:id=\"remeberMeCheckBox\" was not injected: check your FXML file 'signIN.fxml'.";
        assert singInButton != null : "fx:id=\"singInButton\" was not injected: check your FXML file 'signIN.fxml'.";
        
        loginField.setText("example@tut.by");
        passwordField.setText("Желнов");

    }
    
    private void signIn(String loginText,String password) throws IOException {
    	App.setRoot("fillWindow");
    	DatabaseHandler dbHandler = new DatabaseHandler();
    	
    	User user = new User();
    	user.setEmail(loginText);
    	user.setPassword(password);
    	
    	ResultSet resultSet = dbHandler.getUser(user);
    	
    	try {
			if(resultSet.next()) {
				System.out.println("Success!");
				App.setRoot("fillWindow");
			} 
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

}
