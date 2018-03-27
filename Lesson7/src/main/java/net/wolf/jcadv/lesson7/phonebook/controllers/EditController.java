/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson7.phonebook.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.wolf.jcadv.lesson7.phonebook.model.PhoneRecord;

/**
 * FXML Controller class
 *
 * @author Andrey
 */
public class EditController implements Initializable {
    
    @FXML
    private TextField nameEditor;
    
    @FXML
    private TextField phoneEditor;
    
    @FXML
    private ChoiceBox operatorChoiceBox;
    
    private Stage editStage;
    private PhoneRecord phoneRecord;
    private boolean okClicked = false;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        operatorChoiceBox.getItems()
                .addAll("Kievstar", "Vodafone", "Life");
    }    

    public void setEditStage(Stage editStage) {
        this.editStage = editStage;
    }

    public void setPhoneRecord(PhoneRecord phoneRecord) {
        this.phoneRecord = phoneRecord;
        
        nameEditor.setText(phoneRecord.getFullName());
        phoneEditor.setText(phoneRecord.getPhone());
        
        operatorChoiceBox.getSelectionModel().clearSelection();
        operatorChoiceBox.getSelectionModel()
                .select(phoneRecord.getOperator());        
    }

    public PhoneRecord getPhoneRecord() {
        return phoneRecord;
    }

    public boolean isOkClicked() {
        return okClicked;
    }
    
    @FXML
    private void handleOk() {
        if (validate()) {
            phoneRecord.setFullName(nameEditor.getText());
            phoneRecord.setPhone(phoneEditor.getText());
            
            phoneRecord.setOperator(operatorChoiceBox.getSelectionModel().getSelectedItem().toString());
            
            editStage.hide();
            okClicked = true;
        }
    }
    
    @FXML
    private void handleCancel() {
        editStage.hide();
    }

    private boolean validate() {
        return true;
    }
    
    public void edit(PhoneRecord phoneRecord) {
        setPhoneRecord(phoneRecord);
        
        editStage.showAndWait();
    }
}
