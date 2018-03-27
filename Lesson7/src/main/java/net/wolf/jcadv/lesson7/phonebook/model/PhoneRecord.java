/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson7.phonebook.model;

import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Модель данных в телефонном справочнике
 * @author Andrey
 */
public class PhoneRecord {
    
    private final StringProperty fullName;    
        
    private final StringProperty phone;
    
    private final StringProperty operator;

    public PhoneRecord(String fullName, String phone, String operator) {
        this.fullName = new SimpleStringProperty(fullName);
        this.phone = new SimpleStringProperty(phone);
        this.operator = new SimpleStringProperty(operator);
    }
    
    public PhoneRecord() {
        this.fullName = new SimpleStringProperty();
        this.phone = new SimpleStringProperty();
        this.operator = new SimpleStringProperty();
    }

    public StringProperty getFullNameProperty() {
        return fullName;
    }
    
    public String getFullName() {
        return fullName.getValueSafe();
    }

    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }
    
    public StringProperty getPhoneProperty() {
        return phone;
    }
    
    public String getPhone() {
        return phone.getValueSafe();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public StringProperty getOperatorProperty() {
        return operator;
    }
    
    public String getOperator() {
        return operator.getValueSafe();
    }

    public void setOperator(String operator) {
        this.operator.set(operator);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.fullName);
        hash = 23 * hash + Objects.hashCode(this.phone);
        hash = 23 * hash + Objects.hashCode(this.operator);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PhoneRecord other = (PhoneRecord) obj;
        if (!Objects.equals(this.fullName, other.fullName)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.operator, other.operator)) {
            return false;
        }
        return true;
    }
    
}
