/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson9.spring.boot;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andrey
 */
@RestController
public class HelloWorldController {
    
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hellow world!";
    }
    
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public String message(@RequestBody @Valid MessageDto message) {
        return message.getMessage();
    }
}
