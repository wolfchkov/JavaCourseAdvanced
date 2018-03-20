package net.wolf.jcadv.lesson7.phonebook;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import static javafx.application.Application.launch;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.wolf.jcadv.lesson7.phonebook.controllers.MainController;
import net.wolf.jcadv.lesson7.phonebook.model.PhoneRecord;


public class PhoneBookApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        Parent root = mainLoader.load();        
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setMinHeight(640);
        stage.setMinWidth(800);
        stage.setTitle("Phone book 1.0");
        stage.setScene(scene);
        stage.show();
        
        MainController mainController = mainLoader.getController();
        ObservableList<PhoneRecord> phoneRecords = FXCollections.observableArrayList();
        phoneRecords.add(new PhoneRecord("Some Name", "+380508509353", "Vodafone"));
        phoneRecords.add(new PhoneRecord("Some Name", "+380508509353", "Vodafone"));
        phoneRecords.add(new PhoneRecord("Some Name", "+380508509353", "Vodafone"));
        phoneRecords.add(new PhoneRecord("Some Name", "+380508509353", "Vodafone"));
        phoneRecords.add(new PhoneRecord("Some Name", "+380508509353", "Vodafone"));
        mainController.setObservablPhoneRecordList(phoneRecords);
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
