/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package by.bobruisk.zhelnov.myproject.alerts;

import javafx.scene.control.Alert;

/**
 *
 * @author Anton
 */
public class OtherCharsInNumericFields {
    
    
    
        public static void show(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
	alert.setHeaderText("Numeric fields contain other characters that are not numbers");
	alert.setContentText("Please check the entered data:");
	alert.showAndWait(); 
    }
    
}
