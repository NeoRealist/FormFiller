package by.bobruisk.zhelnov.myproject.mavenproject1.Controllers;

import by.bobruisk.zhelnov.myproject.mavenproject1.App;
import by.bobruisk.zhelnov.myproject.mavenproject1.FullName;
import by.bobruisk.zhelnov.myproject.mavenproject1.User;
import by.bobruisk.zhelnov.myproject.mavenproject1.Controllers.dbcontrollers.DatabaseHandler;
import by.bobruisk.zhelnov.myproject.mavenproject1.alerts.HasEmptyFields;
import by.bobruisk.zhelnov.myproject.mavenproject1.alerts.WrongLoginOrPassword;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignInController {

	URL url = App.class.getResource("constants/rememberUser.properties");

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

		if (remeberMeCheckBox.isSelected()) {
			setRememberUser(login, password);
		} else {
			setRememberisation(false);
		}
		System.out.println("Email: " + login);
		System.out.println("Password: " + password);

		if (login.equals("") || password.equals("")) {
			HasEmptyFields.show();
		} else {
			signIn(login, password);
		}

	}

	private boolean hasRemember() {

		File file;
		try {
			file = Paths.get(url.toURI()).toFile();
			FileReader fileReader = new FileReader(file);

			Reader reader = new BufferedReader(fileReader);

			Properties property = new Properties();
			property.load(reader);

			boolean b = false;
			b = Boolean.valueOf(property.get("remember").toString());

			return b;
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@FXML
	void initialize() {
		if (hasRemember()) {
			loginField.setText(getRememberedLogin());
			passwordField.setText(getRememberedPassword());
		}
		assert formFillerLabel != null
				: "fx:id=\"formFillerLabel\" was not injected: check your FXML file 'signIN.fxml'.";
		assert loginField != null : "fx:id=\"loginField\" was not injected: check your FXML file 'signIN.fxml'.";
		assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'signIN.fxml'.";
		assert remeberMeCheckBox != null
				: "fx:id=\"remeberMeCheckBox\" was not injected: check your FXML file 'signIN.fxml'.";
		assert singInButton != null : "fx:id=\"singInButton\" was not injected: check your FXML file 'signIN.fxml'.";

	}

	private void signIn(String loginText, String password) throws IOException {

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

	private void setRememberUser(String login, String password) {
		File file;
		try {
			file = Paths.get(url.toURI()).toFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fw);
			writer.write("remember=true\n");
			writer.write("login=" + login + "\n");
			writer.write("password=" + password + "\n");

			writer.close();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void setRememberisation(boolean hasRemember) {
		File file;
		try {
			file = Paths.get(url.toURI()).toFile();
			FileInputStream in = new FileInputStream(file);
			FileReader fileReader = new FileReader(file);

			Reader reader = new BufferedReader(fileReader);

			Properties property = new Properties();
			property.load(reader);
			in.close();

			FileOutputStream out = new FileOutputStream(file);
			property.setProperty("remember", Boolean.toString(hasRemember));
			property.store(out, null);
			out.close();

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String getRememberedLogin() {
		File file;
		String login;
		try {
			file = Paths.get(url.toURI()).toFile();
			FileReader fileReader = new FileReader(file);

			Reader reader = new BufferedReader(fileReader);

			Properties property = new Properties();
			property.load(reader);

			login = property.get("login").toString();

			return login;
		} catch (URISyntaxException e) {
			System.out.println(1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(3);
		} catch (NullPointerException e) {
			login = "";
		}

		return "";
	}

	private String getRememberedPassword() {
		File file;
		String password;
		try {
			file = Paths.get(url.toURI()).toFile();
			FileReader fileReader = new FileReader(file);

			Reader reader = new BufferedReader(fileReader);

			Properties property = new Properties();
			property.load(reader);

			password = property.get("password").toString();

			return password;
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			password = "";
		}

		return "";
	}

	public static User getUser() {
		return user;
	}

}
