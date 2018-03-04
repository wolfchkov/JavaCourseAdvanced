/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson6.xml.jaxb;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Заоплата сотрудника
 * @author Andrey
 */
@XmlRootElement(name = "staff")
@XmlAccessorType(XmlAccessType.NONE)
public class Staff {
    
    @XmlAttribute(name = "id")
    private int id;
 
    @XmlElement(name = "firstname")
    private String firstName;
    
    @XmlElement(name = "lastname")
    private String lastName;
    
    @XmlElement(name = "nickname")
    private String nick;
    
    @XmlElement(name = "salary")
    private BigDecimal salary;

    public Staff(int id, String firstName, String lastName, String nick, BigDecimal salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nick = nick;
        this.salary = salary;
    }

    public Staff() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Staff{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", nick=" + nick + ", salary=" + salary + '}';
    }
    
}
