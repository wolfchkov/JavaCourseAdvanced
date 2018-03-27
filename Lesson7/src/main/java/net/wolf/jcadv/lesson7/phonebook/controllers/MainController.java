package net.wolf.jcadv.lesson7.phonebook.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import net.wolf.jcadv.lesson7.phonebook.model.PhoneRecord;
import net.wolf.jcadv.lesson7.phonebook.model.PhoneRecordRepository;

public class MainController implements Initializable {

    private Stage mainStage;

    private EditController editController;

    private PhoneRecordRepository phoneRecordRepository;

    @FXML
    private TableView<PhoneRecord> phoneBook;

    @FXML
    private TableColumn<PhoneRecord, String> fnField;

    @FXML
    private TableColumn<PhoneRecord, String> phoneField;

    @FXML
    private TableColumn<PhoneRecord, String> operatorField;

    @FXML
    private Label records;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Инициализация таблицы телефонного справочника
        fnField.setCellValueFactory(p -> p.getValue().getFullNameProperty());
        phoneField.setCellValueFactory(p -> p.getValue().getPhoneProperty());
        operatorField.setCellValueFactory(p -> p.getValue().getOperatorProperty());
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public void setEditController(EditController editController) {
        this.editController = editController;
    }

    public void setPhoneRecordRepository(PhoneRecordRepository phoneRecordRepository) {
        this.phoneRecordRepository = phoneRecordRepository;
        ObservableList<PhoneRecord> phoneRecords = phoneRecordRepository.getAllPhoneRecords();

        //обновим количество записей
        records.setText(String.valueOf(phoneRecords.size()));

        //пслушаем изменение списка телефонной книги и обновляем количество записей
        phoneRecords.addListener(
                (ListChangeListener.Change<? extends PhoneRecord> change) -> records.setText(String.valueOf(change.getList().size()))
        );

        //привязываем наш список к таблице
        phoneBook.setItems(phoneRecords);
    }

    @FXML
    private void handleDeletePhoneRecord() {
        int selectedIndex = phoneBook.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            //удаляем выбранную запись таблицы
            phoneBook.getItems().remove(selectedIndex);
        } else {
            alert();
        }
    }

    private void alert() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.initOwner(mainStage);
        alert.setTitle("Не выбрана запись");
        alert.setHeaderText("Не выбрана запись в справочнике!");
        alert.setContentText("Пожалуйста выберите запись в справочнике.");
        alert.showAndWait();
    }

    @FXML
    private void handleAddPhoneRecord() {
        PhoneRecord phoneRecord = new PhoneRecord();
        editController.edit(phoneRecord);
        phoneRecordRepository.insertPhoneRecord(phoneRecord);
    }

    @FXML
    private void handleEditPhoneRecord() {
        int selectedIndex = phoneBook.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            //удаляем выбранную запись таблицы
            PhoneRecord phoneRecord = phoneBook.getItems().get(selectedIndex);
            editController.edit(phoneRecord);
        } else {
            alert();
        }
    }
}
