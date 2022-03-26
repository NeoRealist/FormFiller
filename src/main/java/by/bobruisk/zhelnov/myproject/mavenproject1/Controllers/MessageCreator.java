/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package by.bobruisk.zhelnov.myproject.mavenproject1.Controllers;

import by.bobruisk.zhelnov.myproject.mavenproject1.Patient;

/**
 *
 * @author Anton
 */
public class MessageCreator {
    boolean hasErrors = true;
    private String message = "";
    
    public void setMessage(ExceptionChecker exceptionChecker,Patient patient){
        if(!exceptionChecker.getHasErrors()){
            message = exceptionChecker.getErrorMessage();
        }else{
            message = "Well done";
        }
    }
    
    public String getMessage(){
        return message;
    }
    
}
