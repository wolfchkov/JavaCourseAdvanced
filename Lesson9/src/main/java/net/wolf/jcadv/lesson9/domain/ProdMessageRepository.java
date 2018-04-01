/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson9.domain;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrey
 */
@Repository
@Profile("prod")
public class ProdMessageRepository implements MessageRepository{

    @Override
    public String getMessage() {
        return "Сообщение с продукционного хранилища!";
    }
    
}
