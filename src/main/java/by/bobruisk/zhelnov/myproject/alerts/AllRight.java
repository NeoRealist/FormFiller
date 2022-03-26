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
public class AllRight {
    
            public static void show(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("All right");
	alert.setHeaderText("All right");
	alert.setContentText("Forms sent for printing");
	alert.showAndWait(); 
    }
    
}
