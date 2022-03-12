package by.bobruisk.zhelnov.myproject.mavenproject1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox BC_Coag_CB;

    @FXML
    private CheckBox GBT_GU_GluAndChol_ECG_CB;

    @FXML
    private CheckBox RW_PCR_CB;

    @FXML
    private Rectangle WRW_1;

    @FXML
    private Rectangle WRW_2;

    @FXML
    private Rectangle WRW_3;

    @FXML
    private Label author;

    @FXML
    private TextField departmentNameTF;

    @FXML
    private TextField doctorNameTF;

    @FXML
    private AnchorPane mainMenu;

    @FXML
    private TextField patientCorpsTF;

    @FXML
    private TextField patientDBdayTF;

    @FXML
    private TextField patientDBmonthTF;

    @FXML
    private TextField patientDByearTF;

    @FXML
    private TextField patientFlatTF;

    @FXML
    private TextField patientHouseTF;

    @FXML
    private TextField patientNameTF;

    @FXML
    private TextField patientPatronymicTF;

    @FXML
    private TextField patientStreetTF;

    @FXML
    private TextField patientSurnameTF;

    @FXML
    private Button printButton;

    @FXML
    private TextField surveyReason;
    
    @FXML
    private void switchToPR() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    void initialize() {
        
    }

}
