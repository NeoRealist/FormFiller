/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package by.bobruisk.zhelnov.myproject.mavenproject1.alerts;

import javafx.scene.control.Alert;

/**
 *
 * @author Anton
 */
public class FieldsFilledOutIncorrectly {
    
        public static void show(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
	alert.setHeaderText("Fields filled out incorrectly");
	alert.setContentText("Because:\n" + message);
	alert.showAndWait(); 
    }
    
}
