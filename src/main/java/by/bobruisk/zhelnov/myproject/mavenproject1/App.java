package by.bobruisk.zhelnov.myproject.mavenproject1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * JavaFX App
 */
public class App extends Application {
	
	
	
	private ResourceBundle bundle = ResourceBundle.getBundle("resources.by.bobruisk.zhelnov.myproject.mavenproject1.i18n.language");	

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {	
    	Locale currentLocale = Locale.getDefault();
//    	Locale currentLocale = new Locale("en_uk");
    	bundle =  ResourceBundle.getBundle("resources.by.bobruisk.zhelnov.myproject.mavenproject1.i18n.language", currentLocale);    	
        scene = new Scene(loadFXML("mainWindow", bundle));
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml, ResourceBundle bundle ) throws IOException {
        scene.setRoot(loadFXML(fxml,bundle));
    }

    private static Parent loadFXML(String fxml, ResourceBundle bundle) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"), bundle);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }



}