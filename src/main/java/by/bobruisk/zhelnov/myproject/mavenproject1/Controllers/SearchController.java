package by.bobruisk.zhelnov.myproject.mavenproject1.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
 
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SearchController implements Initializable {

//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;

    @FXML
    private TextArea searchResultArea;

    @FXML
    private TextField searchTextField;
    
    private static final List<String> words =  Arrays.asList("мешает", "заеду", "изменчивого", "вполне", "красноносый", "степенные", "заглянул", "беда");

//    @FXML
//    void initialize() {
//        assert searchResultArea != null : "fx:id=\"searchResultArea\" was not injected: check your FXML file 'searchWindow.fxml'.";
//        assert searchTextField != null : "fx:id=\"searchTextField\" was not injected: check your FXML file 'searchWindow.fxml'.";
//
//    }
    public void initialize(URL location, ResourceBundle resources) {
    	searchTextField.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                List<String> res = search(newValue);
                
                searchResultArea.clear();
                for(String s : res) {
                	searchResultArea.appendText(s);
                	searchResultArea.appendText("\n");
                }
            }
        });
    }
    
    
    
    
    private static List<String> search(String text) {
        List<String> res = new ArrayList<String>();
        
        for(String s : words) {
            if(s.startsWith(text)) {
                res.add(s);
            }
        }
        
        return res;
    }

}
