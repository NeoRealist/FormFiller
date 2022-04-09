package by.bobruisk.zhelnov.myproject.mavenproject1.Controllers;

import by.bobruisk.zhelnov.myproject.mavenproject1.App;
import by.bobruisk.zhelnov.myproject.mavenproject1.FullName;
import by.bobruisk.zhelnov.myproject.mavenproject1.User;
import by.bobruisk.zhelnov.myproject.mavenproject1.Controllers.dbcontrollers.DatabaseHandler;
import by.bobruisk.zhelnov.myproject.mavenproject1.alerts.HasEmptyFields;
import by.bobruisk.zhelnov.myproject.mavenproject1.alerts.WrongLoginOrPassword;


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



	private static User user;

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
		

		if (login.equals("") || password.equals("")) {
			HasEmptyFields.show();
		} else {
			signIn(login, password);
		}

	}

	@FXML
	void initialize() {
		loginField.setText("example@tut.by");
		passwordField.setText("12345678");
		assert formFillerLabel != null
				: "fx:id=\"formFillerLabel\" was not injected: check your FXML file 'signIN.fxml'.";
		assert loginField != null : "fx:id=\"loginField\" was not injected: check your FXML file 'signIN.fxml'.";
		assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'signIN.fxml'.";
		assert remeberMeCheckBox != null
				: "fx:id=\"remeberMeCheckBox\" was not injected: check your FXML file 'signIN.fxml'.";
		assert singInButton != null : "fx:id=\"singInButton\" was not injected: check your FXML file 'signIN.fxml'.";



	}

	private void signIn(String loginText, String password) throws IOException {
//    	App.setRoot("fillWindow");
		DatabaseHandler dbHandler = new DatabaseHandler();

		User user = new User();


		user.setEmail(loginText);
		user.setPassword(password);

		ResultSet resultSet = dbHandler.hasUser(loginText, password);

		try {
			if (resultSet.next()) {
				setUser(resultSet, user);

				System.out.println("Success!");

				App.setRoot("fillWindow", resources);
			} else {
				WrongLoginOrPassword.show();
			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void setUser(ResultSet resultSet, User user) throws SQLException {
		user.setId(resultSet.getInt(1));
		user.setFullName(new FullName(resultSet.getString(3), resultSet.getString(2), resultSet.getString(4)));
		user.setOrganizationName(resultSet.getString(5));
		user.setDepartmentName(resultSet.getString(6));
		user.setSpeciality(resultSet.getString(7));
		user.setEmail(resultSet.getString(8));
		user.setPassword(resultSet.getString(9));

		SignInController.user = user;

	}

	public static User getUser() {
		return user;
	}

}
