/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson6.json.map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;

/**
 *
 * @author Andrey
 */
public class MoneySerializer extends StdSerializer<Money> {

    public MoneySerializer() {
        this(null);
    }

    public MoneySerializer(Class<Money> klass) {
        super(klass);
    }

    @Override
    public void serialize(Money m, JsonGenerator jg, SerializerProvider sp) throws IOException {
        jg.writeString(m.getAmount() + " " + m.getCurrency());
    }
    
}
