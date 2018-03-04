/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson6.json.map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 *
 * @author Andrey
 */
public class Staff {
    
    @JsonProperty("someId")
    private final int id;
 
    @JsonProperty("name")
    private final String firstName;
    
    @JsonProperty("lastName")
    private final String lastName;
    
    @JsonProperty("nickName")
    private final String nick;
    
    @JsonProperty("salary")
    private final BigDecimal salary;

    @JsonCreator
    public Staff(
            @JsonProperty("someId")int id, 
            @JsonProperty("name") String firstName, 
            @JsonProperty("lastName") String lastName, 
            @JsonProperty("nickName") String nick, 
            @JsonProperty("salary") BigDecimal salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nick = nick;
        this.salary = salary;
    }
    
    

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNick() {
        return nick;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Staff{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", nick=" + nick + ", salary=" + salary + '}';
    }
}
