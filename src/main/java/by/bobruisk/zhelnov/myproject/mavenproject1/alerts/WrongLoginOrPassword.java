package by.bobruisk.zhelnov.myproject.mavenproject1.alerts;

import javafx.scene.control.Alert;

public class WrongLoginOrPassword {

	public static void show() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Wrong login or password");
		alert.setContentText("Please check the information and try again");
		alert.showAndWait();
	}

}
