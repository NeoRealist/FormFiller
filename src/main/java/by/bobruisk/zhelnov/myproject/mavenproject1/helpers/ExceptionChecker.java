/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package by.bobruisk.zhelnov.myproject.mavenproject1.helpers;

import by.bobruisk.zhelnov.myproject.mavenproject1.BirthDate;

import by.bobruisk.zhelnov.myproject.mavenproject1.FullName;
import by.bobruisk.zhelnov.myproject.mavenproject1.HomeAddress;
import by.bobruisk.zhelnov.myproject.mavenproject1.Patient;
import java.util.Calendar;
import java.util.regex.Pattern;

/**
 *
 * @author Anton
 */
public class ExceptionChecker {

	Pattern patternForStreet1 = Pattern.compile("^([A-Za-zА-Яа-я0-9\\s-]{3,15})?[A-Za-zА-Яа-я0-9\\s]{2,25}$");
	Pattern patternForStreet2 = Pattern
			.compile("(((У|у)лица)|((П|п)роезд)|((П|п)роспект)|((Б|б)ульвар)|((П|п)ереулок))+");
	Pattern patternForFullNameFields = Pattern.compile("^[A-ZА-Я]{1}[a-zа-яё]{1,25}[-]?([A-ZА-Я]{1}[a-zа-яё]{1,25})?$");
	Pattern patternForYearOfBirth = Pattern.compile("[1-2]{1}[90]{1}[0-9]{1}[0-9]{1}");

	Patient dataPatient;

	private String errorMessage = "";

	boolean hasErrors = false;

	public boolean hasErrors() {

		return hasErrors;
	}

	public void checkAll(Patient patient) {
		checkFullName(patient.getFullName());
		checkBirthDate(patient.getBirthDate());
		checkHomeAddress(patient.getHomeAdress());
		if (!errorMessage.equals("")) {
			hasErrors = true;
		}
	}

	private void checkFullName(FullName fullName) {
		if (!fullName.getSurname().matches(patternForFullNameFields.pattern())) {
			setErrorMessage(errorMessage + "Wrong Surname\n");
		}
		if (!fullName.getName().matches(patternForFullNameFields.pattern())) {
			setErrorMessage(errorMessage + "Wrong Name\n");

		}
		if (!fullName.getPatronymic().matches(patternForFullNameFields.pattern())) {
			setErrorMessage(errorMessage + "Wrong Patronymic\n");

		}

	}

	private void checkBirthDate(BirthDate birthDate) {
		if (birthDate.getDay() == 0) {
			setErrorMessage(errorMessage + "Day cannot be 0\n");
		}
		if (birthDate.getMonth() == 0) {
			setErrorMessage(errorMessage + "Month cannot be 0\n");
		}
		if (birthDate.getYear() < 1900 || birthDate.getYear() > Calendar.getInstance().get(Calendar.YEAR)) {
			setErrorMessage(
					errorMessage + "Year should be from 1900 to " + Calendar.getInstance().get(Calendar.YEAR) + "\n");
		}

	}

	private void checkHomeAddress(HomeAddress homeAddress) {
		if (!homeAddress.getStreetName().matches(patternForStreet1.pattern())
				|| homeAddress.getStreetName().matches(patternForStreet2.pattern())) {
			setErrorMessage(errorMessage + "Wrong street\n");
		}
		if(homeAddress.getHomeNumber() == 0) {
			setErrorMessage(errorMessage + "Home number not can be 0\n");
		}


	}

	public boolean getHasErrors() {
		return hasErrors;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String message) {
		this.errorMessage = message;
	}

}
