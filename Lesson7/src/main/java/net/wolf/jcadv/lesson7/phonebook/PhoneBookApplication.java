package net.wolf.jcadv.lesson7.phonebook;

import java.io.IOException;
import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.wolf.jcadv.lesson7.phonebook.controllers.EditController;
import net.wolf.jcadv.lesson7.phonebook.controllers.MainController;
import net.wolf.jcadv.lesson7.phonebook.model.InMemoryPhoneRecordRepository;
import net.wolf.jcadv.lesson7.phonebook.model.PhoneRecordRepository;

/**
 * Главный класс приложения.
 * 
 * @author Andrey
 */
public class PhoneBookApplication extends Application {

    private final PhoneRecordRepository phoneRecordRepository = new InMemoryPhoneRecordRepository();

    /**
     * Главная сцена
     */
    private Stage mainStage;
    
    /**
     * Главный контроллер 
     */
    private MainController mainController;
    
    /**
     * Контроллер для редактирования
     */
    private EditController editController;

    @Override
    public void start(Stage stage) throws Exception {
        this.mainStage = stage;
        initMainController();
        initEditController();
    }

    private void initMainController() throws IOException {
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        Parent root = mainLoader.load();

        Scene scene = new Scene(root);
        //scene.getStylesheets().add("/styles/Styles.css");
        mainController = mainLoader.getController();
        mainController.setPhoneRecordRepository(phoneRecordRepository);
        mainController.setMainStage(mainStage);

        mainStage.setMinHeight(640);
        mainStage.setMinWidth(800);
        mainStage.setTitle("Phone book 1.0");
        mainStage.setScene(scene);
        mainStage.show();
    }

    private void initEditController() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/edit.fxml"));
        Parent page = loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Редактор");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(mainStage);
        
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
        editController = loader.getController();
        editController.setEditStage(dialogStage);
        
        mainController.setEditController(editController);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
