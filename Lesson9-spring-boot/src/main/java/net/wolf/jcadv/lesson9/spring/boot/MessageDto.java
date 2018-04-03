/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson9.spring.boot;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Andrey
 */
public class MessageDto {

    @JsonProperty("message_id")
    private int id;

    @JsonProperty("message_text")
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
