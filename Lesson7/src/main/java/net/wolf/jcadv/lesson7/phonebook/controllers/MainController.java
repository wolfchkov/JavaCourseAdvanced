package net.wolf.jcadv.lesson7.phonebook.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import net.wolf.jcadv.lesson7.phonebook.model.PhoneRecord;

public class MainController implements Initializable {
    
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
        fnField.setCellValueFactory(p -> p.getValue().getFullName());
        phoneField.setCellValueFactory(p -> p.getValue().getPhone());
        operatorField.setCellValueFactory(p -> p.getValue().getOperator());
    }
    
    public void setObservablPhoneRecordList(ObservableList<PhoneRecord> phoneRecords) {
        phoneBook.setItems(phoneRecords);     
    }
}


