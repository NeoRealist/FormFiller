/*
  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package by.bobruisk.zhelnov.myproject.mavenproject1.Controllers;

import by.bobruisk.zhelnov.myproject.mavenproject1.App;
import by.bobruisk.zhelnov.myproject.mavenproject1.FullName;

import by.bobruisk.zhelnov.myproject.mavenproject1.User;
import by.bobruisk.zhelnov.myproject.mavenproject1.Controllers.dbcontrollers.DatabaseHandler;
import by.bobruisk.zhelnov.myproject.mavenproject1.alerts.PasswordDoNotMatch;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
	private void switchToMainWindow() throws IOException, ClassNotFoundException, SQLException {
		signUpNewUser();

		if (passwordField.getText().equals(passwordRepeatField.getText())) {
			User newUser = new User(
					new FullName(surnameTextField.getText(), nameTextField.getText(), patronymicTextField.getText()),
					emailField.getText(), specialityTextField.getText(), organizationTextField.getText(),
					departmentTextField.getText(), passwordField.getText());
			System.out.println(newUser);
			App.setRoot("mainWindow", resources);
		} else {
			PasswordDoNotMatch.show();
		}

	}

	@FXML
	void initialize() {
		loginText.setText(emailField.getText());
		assert departmentTextField != null
				: "fx:id=\"departmentTextField\" was not injected: check your FXML file 'signUp.fxml'.";
		assert emailField != null : "fx:id=\"emailField\" was not injected: check your FXML file 'signUp.fxml'.";
		assert formFillerLabel != null
				: "fx:id=\"formFillerLabel\" was not injected: check your FXML file 'signUp.fxml'.";
		assert loginText != null : "fx:id=\"loginText\" was not injected: check your FXML file 'signUp.fxml'.";
		assert nameTextField != null : "fx:id=\"nameTextField\" was not injected: check your FXML file 'signUp.fxml'.";
		assert organizationTextField != null
				: "fx:id=\"organizationTextField\" was not injected: check your FXML file 'signUp.fxml'.";
		assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'signUp.fxml'.";
		assert passwordRepeatField != null
				: "fx:id=\"passwordRepeatField\" was not injected: check your FXML file 'signUp.fxml'.";
		assert patronymicTextField != null
				: "fx:id=\"patronymicTextField\" was not injected: check your FXML file 'signUp.fxml'.";
		assert specialityTextField != null
				: "fx:id=\"specialityTextField\" was not injected: check your FXML file 'signUp.fxml'.";
		assert surnameTextField != null
				: "fx:id=\"surnameTextField\" was not injected: check your FXML file 'signUp.fxml'.";

	}

	private void signUpNewUser() throws ClassNotFoundException, SQLException {
		DatabaseHandler dbHandler = new DatabaseHandler();
		String name = nameTextField.getText();
		String surname = surnameTextField.getText();
		String patronymic = patronymicTextField.getText();
		String organisation = organizationTextField.getText();
		String department = departmentTextField.getText();
		String speciality = specialityTextField.getText();
		String email = emailField.getText();
		String password = passwordField.getText();

		FullName fullname = new FullName(surname, name, patronymic);

		User user = new User(fullname, organisation, department, speciality, email, password);

		dbHandler.signUpUser(user);
	}

}
