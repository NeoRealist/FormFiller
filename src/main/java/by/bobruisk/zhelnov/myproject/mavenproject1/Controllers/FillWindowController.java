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
import by.bobruisk.zhelnov.myproject.mavenproject1.BirthDate;
import by.bobruisk.zhelnov.myproject.mavenproject1.FullName;
import by.bobruisk.zhelnov.myproject.mavenproject1.HomeAdress;
import by.bobruisk.zhelnov.myproject.mavenproject1.Patient;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class FillWindowController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Rectangle blueRectangle;

	@FXML
	private CheckBox BC_Coag_CB;

	@FXML
	private CheckBox GBT_GU_GluAndChol_ECG_CB;

	@FXML
	private CheckBox RW_PCR_CB;

	@FXML
	private TextField buildNumberTextField;

	@FXML
	private TextField dayOfTheBirthdayTextField;

	@FXML
	private TextField departmentTextField;

	@FXML
	private TextField doctorTextField;

	@FXML
	private AnchorPane fillWindow;

	@FXML
	private TextField flatNumberTextField;

	@FXML
	private Label formFillerLabel;

	@FXML
	private TextField homeNumberTextField;

	@FXML
	private TextField monthOfTheBirthdayTextField;

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField organizationTextField;

	@FXML
	private TextField patromymicTextField;

	@FXML
	private Button printButton;

	@FXML
	private Button quitButton;

	@FXML
	private TextField streetTextField;

	@FXML
	private TextField surnameTextField;

	@FXML
	private TextField surveyReasonTextField;

	@FXML
	private Text userNameField;

	@FXML
	private TextField yearOfTheBirthdayTextField;

	@FXML
	private void switchToMainWindow() throws IOException {
		App.setRoot("mainWindow");
	}

	@FXML
	void initialize() {
		assert BC_Coag_CB != null : "fx:id=\"BC_Coag_CB\" was not injected: check your FXML file 'fillWindow.fxml'.";
		assert GBT_GU_GluAndChol_ECG_CB != null
				: "fx:id=\"GBT_GU_GluAndChol_ECG_CB\" was not injected: check your FXML file 'fillWindow.fxml'.";
		assert RW_PCR_CB != null : "fx:id=\"RW_PCR_CB\" was not injected: check your FXML file 'fillWindow.fxml'.";
		assert buildNumberTextField != null
				: "fx:id=\"buildNumberTextField\" was not injected: check your FXML file 'fillWindow.fxml'.";
		assert dayOfTheBirthdayTextField != null
				: "fx:id=\"dayOfTheBirthdayTextField\" was not injected: check your FXML file 'fillWindow.fxml'.";
		assert departmentTextField != null
				: "fx:id=\"departmentTextField\" was not injected: check your FXML file 'fillWindow.fxml'.";
		assert doctorTextField != null
				: "fx:id=\"doctorTextField\" was not injected: check your FXML file 'fillWindow.fxml'.";
		assert fillWindow != null : "fx:id=\"fillWindow\" was not injected: check your FXML file 'fillWindow.fxml'.";
		assert flatNumberTextField != null
				: "fx:id=\"flatNumberTextField\" was not injected: check your FXML file 'fillWindow.fxml'.";
		assert homeNumberTextField != null
				: "fx:id=\"homeNumberTextField\" was not injected: check your FXML file 'fillWindow.fxml'.";
		assert monthOfTheBirthdayTextField != null
				: "fx:id=\"monthOfTheBirthdayTextField\" was not injected: check your FXML file 'fillWindow.fxml'.";
		assert nameTextField != null
				: "fx:id=\"nameTextField\" was not injected: check your FXML file 'fillWindow.fxml'.";
		assert patromymicTextField != null
				: "fx:id=\"patromymicTextField\" was not injected: check your FXML file 'fillWindow.fxml'.";
		assert printButton != null : "fx:id=\"printButton\" was not injected: check your FXML file 'fillWindow.fxml'.";
		assert quitButton != null : "fx:id=\"quitButton\" was not injected: check your FXML file 'fillWindow.fxml'.";
		assert streetTextField != null
				: "fx:id=\"streetTextField\" was not injected: check your FXML file 'fillWindow.fxml'.";
		assert surnameTextField != null
				: "fx:id=\"surnameTextField\" was not injected: check your FXML file 'fillWindow.fxml'.";
		assert surveyReasonTextField != null
				: "fx:id=\"surveyReasonTextField\" was not injected: check your FXML file 'fillWindow.fxml'.";
		assert userNameField != null
				: "fx:id=\"userNameField\" was not injected: check your FXML file 'fillWindow.fxml'.";
		assert yearOfTheBirthdayTextField != null
				: "fx:id=\"yearOfTheBirthdayTextField\" was not injected: check your FXML file 'fillWindow.fxml'.";

	}

	public void setPatientData() {
		FullName fullName = new FullName(surnameTextField.getText(), nameTextField.getText(),
				patromymicTextField.getText());
		BirthDate birthDate = new BirthDate(Integer.parseInt(dayOfTheBirthdayTextField.getText()),
				Integer.parseInt(monthOfTheBirthdayTextField.getText()),
				Integer.parseInt(yearOfTheBirthdayTextField.getText()));
		HomeAdress homeAdress = new HomeAdress(streetTextField.getText(),
				Integer.parseInt(homeNumberTextField.getText()), buildNumberTextField.getText(),
				Integer.parseInt(flatNumberTextField.getText()));
		Patient patient = new Patient(fullName, birthDate, homeAdress);
		System.out.println(patient);

	}

}
