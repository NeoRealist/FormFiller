/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package by.bobruisk.zhelnov.myproject.mavenproject1.Controllers;

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
    
    Pattern patternForStreet = Pattern.compile("^([A-Za-zА-Яа-я0-9\\s]-)?[A-Za-zА-Яа-я0-9\\s]{2,25}$");
    Pattern patternForFullNameFields = Pattern.compile("^[A-Za-zА-Яа-я]{2,25}[-]?[A-Za-zА-Яа-я]{2,25}$");
    Pattern patternForYearOfBirth= Pattern.compile("[1-2]{1}[90]{1}[0-9]{1}[0-9]{1}");
    
    Patient dataPatient;
    
    private String errorMessage = "";
    
    boolean hasErrors = false;
    
    public boolean hasErrors(){
        
        return hasErrors;
    }
    
    public void checkAll(Patient patient){
        checkFullName(patient.getFullName());
        checkBirthDate(patient.getBirthDate());
        checkHomeAddress(patient.getHomeAdress());
        if(!errorMessage.equals("")){
            hasErrors = true;
        }
    }
    
    private void checkFullName(FullName fullName){
        if(fullName.getSurname().length() <2){
            setErrorMessage(errorMessage + "Very short Surname\n");
        }
        if(fullName.getName().length() <2){
            setErrorMessage(errorMessage + "Very short Name\n");
            
        }
        if(fullName.getPatronymic().length() <2){
            setErrorMessage(errorMessage + "Very short Patronymic\n");
            
        }

                
    }
    
    private void checkBirthDate(BirthDate birthDate) {
        if(birthDate.getDay()==0){
            setErrorMessage(errorMessage + "Day cannot be 0\n");    
        }    
        if(birthDate.getMonth()==0){
            setErrorMessage(errorMessage + "Month cannot be 0\n");    
        } 
        if(birthDate.getYear()<1900 || birthDate.getYear()> Calendar.getInstance().get(Calendar.YEAR) ){
            setErrorMessage(errorMessage + "Year should be from 1900 to " + Calendar.getInstance().get(Calendar.YEAR) + "\n");  
        }
            
    }
  
    
    private void checkHomeAddress(HomeAddress homeAddress){
        
    }
    
    
    public boolean getHasErrors(){
        return hasErrors;
    }
    
    public String getErrorMessage(){
        return errorMessage;
    }

    public void setErrorMessage(String message) {
        this.errorMessage = message;
    }
    
    
}
