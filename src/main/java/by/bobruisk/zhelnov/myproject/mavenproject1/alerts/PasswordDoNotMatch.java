package by.bobruisk.zhelnov.myproject.mavenproject1.alerts;

import javafx.scene.control.Alert;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Anton
 */
public class PasswordDoNotMatch {
    
    public static void show(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
	alert.setHeaderText("Password do not match");
	alert.setContentText("Please check the password entry fields, they must match");
	alert.showAndWait(); 
    }
    
}
