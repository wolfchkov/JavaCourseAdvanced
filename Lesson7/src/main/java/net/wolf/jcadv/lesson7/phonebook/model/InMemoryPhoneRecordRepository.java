/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson7.phonebook.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Andrey
 */
public class InMemoryPhoneRecordRepository implements PhoneRecordRepository {

    private final ObservableList<PhoneRecord> phoneRecords;

    public InMemoryPhoneRecordRepository() {
        phoneRecords = FXCollections.observableArrayList();
        phoneRecords.add(new PhoneRecord("Петр Петров", "+380501234567", "Vodafone"));
        phoneRecords.add(new PhoneRecord("Иван Иванов", "+380507654321", "Vodafone"));
        phoneRecords.add(new PhoneRecord("Илья Ильин",  "+380663333333", "Vodafone"));
        phoneRecords.add(new PhoneRecord("Александр Александров", "+380678509353", "Kievstar"));
        phoneRecords.add(new PhoneRecord("Виктор Викторовский", "+38098977777", "Kievstar"));
    }
    
    @Override
    public ObservableList<PhoneRecord> getAllPhoneRecords() {
        return phoneRecords;
    }

    @Override
    public void insertPhoneRecord(PhoneRecord phoneRecord) {
        phoneRecords.add(phoneRecord);
    }

    @Override
    public void deletePhoneRecord(PhoneRecord phoneRecord) {
        phoneRecords.remove(phoneRecord);
    }
    
}
