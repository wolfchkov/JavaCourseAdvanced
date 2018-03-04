/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson6.xml.jaxb;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrey
 */
@XmlRootElement(name = "company")
@XmlAccessorType(XmlAccessType.NONE)
public class Company {

    @XmlElement(name = "staff")
    private List<Staff> staffList;

    public Company(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public Company() {
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    @Override
    public String toString() {
        return "Company{" + "staffList=" + staffList + '}';
    }
    
}
