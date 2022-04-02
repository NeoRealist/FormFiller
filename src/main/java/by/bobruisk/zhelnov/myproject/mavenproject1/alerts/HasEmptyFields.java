package by.bobruisk.zhelnov.myproject.mavenproject1.alerts;

import javafx.scene.control.Alert;

public class HasEmptyFields {
	public static void show() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Еhere are empty fields");
		alert.setContentText("Please fill in the empty fields");
		alert.showAndWait();
	}
}
