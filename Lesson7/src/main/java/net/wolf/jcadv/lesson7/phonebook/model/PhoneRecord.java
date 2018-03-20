/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson7.phonebook.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Модель данных в телефонном справочнике
 * @author Andrey
 */
public class PhoneRecord {
    
    private StringProperty fullName;    
        
    private StringProperty phone;
    
    private StringProperty operator;

    public PhoneRecord(String fullName, String phone, String operator) {
        this.fullName = new SimpleStringProperty(fullName);
        this.phone = new SimpleStringProperty(phone);
        this.operator = new SimpleStringProperty(operator);
    }

    public StringProperty getFullName() {
        return fullName;
    }

    public void setFullName(StringProperty fullName) {
        this.fullName = fullName;
    }
    
    public StringProperty getPhone() {
        return phone;
    }

    public void setPhone(StringProperty phone) {
        this.phone = phone;
    }

    public StringProperty getOperator() {
        return operator;
    }

    public void setOperator(StringProperty operator) {
        this.operator = operator;
    }
}
