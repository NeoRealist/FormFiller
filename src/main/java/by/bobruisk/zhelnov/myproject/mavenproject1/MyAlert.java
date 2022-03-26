/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package by.bobruisk.zhelnov.myproject.mavenproject1;

import javafx.scene.control.Alert;

/**
 *
 * @author Anton
 */
public class MyAlert {
    
    public static void show(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Моя ошибка");
	alert.setHeaderText("Тест: Это хеадер");
	alert.setContentText("Тест: Тут контекст");
	alert.showAndWait(); 
    }
    
    
    
    
}
