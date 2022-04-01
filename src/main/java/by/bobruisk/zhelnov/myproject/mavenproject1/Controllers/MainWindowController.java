
package by.bobruisk.zhelnov.myproject.mavenproject1.Controllers;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import by.bobruisk.zhelnov.myproject.mavenproject1.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class MainWindowController extends App {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label formFillerLabel;

	@FXML
	private ChoiceBox<String> language;

	@FXML
	private Button signInButton;

	@FXML
	private Button signUpButton;

	@FXML
	private void switchToSignUp() throws IOException {
        App.setRoot("signUp", resources);
	}

	@FXML
	private void switchToSignIn() throws IOException {
        App.setRoot("signIn",resources);

	}

	@FXML
	void initialize() {

		ObservableList<String> langs = FXCollections.observableArrayList("Русский", "English");
		language.getItems().addAll(langs);

		Locale locale = resources.getLocale();
		System.out.println(locale.toString());

		setLanguage(language, locale);

		assert language != null : "fx:id=\"language\" was not injected: check your FXML file 'mainWindow.fxml'.";
		assert formFillerLabel != null
				: "fx:id=\"formFillerLabel\" was not injected: check your FXML file 'mainWindow.fxml'.";
		assert signInButton != null
				: "fx:id=\"signInButton\" was not injected: check your FXML file 'mainWindow.fxml'.";
		assert signUpButton != null
				: "fx:id=\"signUpButton\" was not injected: check your FXML file 'mainWindow.fxml'.";

	}

	
	private static void setLanguage(ChoiceBox<String> language, Locale locale) {
		if ("en_uk".equalsIgnoreCase(locale.toString())) {
			language.setValue("English");
		} else if ("ru_ru".equalsIgnoreCase(locale.toString())) {
			language.setValue("Русский");
		}
		language.setOnAction(event -> {
			try {
				if (language.getValue().equals("Русский")) {
					App.setRoot("mainWindow", getRuBundle());

				} else {
					App.setRoot("mainWindow", getEnBundle());

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}

	public static ResourceBundle getRuBundle() {
		return ResourceBundle.getBundle("resources.by.bobruisk.zhelnov.myproject.mavenproject1.i18n.language",
				new Locale("ru_RU"));
	}

	public static ResourceBundle getEnBundle() {
		return ResourceBundle.getBundle("resources.by.bobruisk.zhelnov.myproject.mavenproject1.i18n.language",
				new Locale("en_UK"));
	}

}
