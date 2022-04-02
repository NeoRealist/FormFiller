/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package by.bobruisk.zhelnov.myproject.mavenproject1.Controllers;

import by.bobruisk.zhelnov.myproject.mavenproject1.App;
import by.bobruisk.zhelnov.myproject.mavenproject1.BirthDate;
import by.bobruisk.zhelnov.myproject.mavenproject1.Exceptions.IncorrectNumberException;
import by.bobruisk.zhelnov.myproject.mavenproject1.alerts.AllRight;
import by.bobruisk.zhelnov.myproject.mavenproject1.alerts.FieldsFilledOutIncorrectly;
import by.bobruisk.zhelnov.myproject.mavenproject1.alerts.OtherCharsInNumericFields;
import by.bobruisk.zhelnov.myproject.mavenproject1.helpers.ExceptionChecker;
import by.bobruisk.zhelnov.myproject.mavenproject1.helpers.Printer;
import by.bobruisk.zhelnov.myproject.mavenproject1.FullName;
import by.bobruisk.zhelnov.myproject.mavenproject1.HomeAddress;
import by.bobruisk.zhelnov.myproject.mavenproject1.Patient;
import by.bobruisk.zhelnov.myproject.mavenproject1.Controllers.dbcontrollers.DatabaseHandler;

import java.io.File;

import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import java.util.ResourceBundle;

import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import com.spire.xls.FileFormat;

import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;



public class FillWindowController {

	boolean hasErrors;

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
		App.setRoot("mainWindow",resources);
	}

	@FXML
	private ComboBox<Integer> dayComboBox;

	@FXML
	private ComboBox<Integer> monthComboBox;

	@FXML
	void initialize() {
		ObservableList<Integer> dayList = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 11, 12,
				13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31);
		dayComboBox.setItems(dayList);
		dayComboBox.setValue(0);
		ObservableList<Integer> monthList = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 11, 12);
		monthComboBox.setItems(monthList);
		monthComboBox.setValue(0);
		System.out.println();

		userNameField.setText(SignInController.getUser().getFullName().getName() + " "
				+ SignInController.getUser().getFullName().getSurname());
		organizationTextField.setText(SignInController.getUser().getOrganizationName());
		departmentTextField.setText(SignInController.getUser().getDepartmentName());
		doctorTextField.setText(SignInController.getUser().getSpeciality() +" " +  SignInController.getUser().getFullName().getName().substring(0, 1) + "."
				+ SignInController.getUser().getFullName().getPatronymic().substring(0, 1) + ". "
				+ SignInController.getUser().getFullName().getSurname());
		surveyReasonTextField.setText("Обследование");

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

	public void onAction() throws Exception {
		File fileForPrint = new File(System.getProperty("user.home") + "/Desktop/Print.xlsx");

		Patient patient = getPatient();
		System.out.println(patient + " Выбранные анализы: "+ getTextFromSelectedCheckbox());
		checkingPatientFields(patient);
		if(!hasErrors) {		
		FillFileForPrint(patient, fileForPrint);
		Printer p = new Printer();
		p.printExcelFile(fileForPrint);
		System.gc();
		fileForPrint.delete();
		DatabaseHandler dbHandler = new DatabaseHandler();
		dbHandler.addEntry(patient, surveyReasonTextField.getText(), getTextFromSelectedCheckbox());

		}

	}

	public Patient getPatient() {

		try {
			FullName fullName = new FullName(surnameTextField.getText(), nameTextField.getText(),
					patromymicTextField.getText());
			BirthDate birthDate = new BirthDate(dayComboBox.getValue(), monthComboBox.getValue(),
					Integer.parseInt(yearOfTheBirthdayTextField.getText()));
//		HomeAddress homeAdress = new HomeAddress(streetTextField.getText(),
//				Integer.parseInt(homeNumberTextField.getText()), buildNumberTextField.getText(),
//				Integer.parseInt(flatNumberTextField.getText()));
			HomeAddress homeAddress = new HomeAddress();
			homeAddress.setStreetName(streetTextField.getText());
			if (homeNumberTextField.getText().equals("")) {
				homeAddress.setHomeNumber(0);
			} else {
				homeAddress.setHomeNumber(Integer.parseInt(homeNumberTextField.getText()));
			}
			homeAddress.setHomeBuildingNumber(buildNumberTextField.getText());
			if (flatNumberTextField.getText().equals("")) {
				homeAddress.setFlat(0);
			} else {
				homeAddress.setFlat(Integer.parseInt(flatNumberTextField.getText()));
			}

			Patient patient = new Patient(fullName, birthDate, homeAddress);

			return patient;
		} catch (NumberFormatException e) {
			OtherCharsInNumericFields.show();
		} catch (IncorrectNumberException ex) {
			FieldsFilledOutIncorrectly.show("Filed Year equals 0");
		}
		return null;

	}

	private void checkingPatientFields(Patient patient) {
		ExceptionChecker ec = new ExceptionChecker();
		ec.checkAll(patient);
		if (ec.getHasErrors()) {
			hasErrors =true;
			FieldsFilledOutIncorrectly.show(ec.getErrorMessage());
		} else {			
			hasErrors = false;
			AllRight.show();
		}

	}

	private void fillDoctorFieldInWorkbook(Workbook workbook) {
		Worksheet worksheet = workbook.getWorksheets().get(0);
		worksheet.getCellRange("A1").setText(organizationTextField.getText());
		worksheet.getCellRange("C54").setText(SignInController.getUser().getSpeciality());
		worksheet.getCellRange("F54").setText(SignInController.getUser().getFullName().getName().substring(0, 1) + "."
				+ SignInController.getUser().getFullName().getPatronymic().substring(0, 1) + ". "
				+ SignInController.getUser().getFullName().getSurname());
		worksheet.getCellRange("K54").setText(surveyReasonTextField.getText());
		worksheet.getCellRange("L55").setText(departmentTextField.getText());

	}

	private void fillPatientFieldsInWorkbook(Patient patient, Workbook workbook) {
		Worksheet worksheet = workbook.getWorksheets().get(0);
		worksheet.getCellRange("C55").setText(patient.getFullName().getSurname());
		worksheet.getCellRange("E55").setText(patient.getFullName().getName());
		worksheet.getCellRange("F55").setText(patient.getFullName().getPatronymic());
		worksheet.getCellRange("D56").setText(String.valueOf(patient.getBirthDate().getDay()));
		worksheet.getCellRange("E56").setText(String.valueOf(patient.getBirthDate().getMonth()));
		worksheet.getCellRange("F56").setText(String.valueOf(patient.getBirthDate().getYear()));
		worksheet.getCellRange("C57").setText(String.valueOf(patient.getHomeAdress().getStreetName()));
		worksheet.getCellRange("E57").setText(String.valueOf(patient.getHomeAdress().getHomeNumber()));
		worksheet.getCellRange("F57").setText(String.valueOf(patient.getHomeAdress().getHomeBuildingNumber()));
		worksheet.getCellRange("G57").setText(String.valueOf(patient.getHomeAdress().getFlatNumber()));

	}

	private void FillFileForPrint(Patient patient, File fileForPrint) {
		Workbook originalWorkbook = new Workbook();

		InputStream is = App.class.getResourceAsStream("Original.xlsx");

		originalWorkbook.loadFromStream(is);

		fillPatientFieldsInWorkbook(patient, originalWorkbook);
		fillDoctorFieldInWorkbook(originalWorkbook);

		originalWorkbook.calculateAllValue();

		originalWorkbook.saveToFile(fileForPrint.getAbsolutePath(), FileFormat.Version2013);

		Workbook workbookForPrint = originalWorkbook;

		List<CheckBox> checkboxes = new ArrayList<>();
		checkboxes.add(GBT_GU_GluAndChol_ECG_CB);
		checkboxes.add(BC_Coag_CB);
		checkboxes.add(RW_PCR_CB);

		int indexForDelete = 0;
		for (int i = 0; i < checkboxes.size(); i++) {
			if (!checkboxes.get(i).isSelected()) {
				workbookForPrint.getWorksheets().get(checkboxes.indexOf(checkboxes.get(indexForDelete))).remove();
			} else {
				indexForDelete++;
			}

		}

		workbookForPrint.saveToFile(fileForPrint.getAbsolutePath());

	}
	private String getTextFromSelectedCheckbox() {
		String selectedCheckboxes = "";
		List<CheckBox> checkboxes = new ArrayList<>();
		checkboxes.add(GBT_GU_GluAndChol_ECG_CB);
		checkboxes.add(BC_Coag_CB);
		checkboxes.add(RW_PCR_CB);
		for (CheckBox checkBox : checkboxes) {
			if(checkBox.isSelected()) {
				selectedCheckboxes += checkBox.getText();				
			}
		}
		
		return selectedCheckboxes;
	}

}
