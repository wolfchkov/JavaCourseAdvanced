/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson6.json.map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Currency;

/**
 *
 * @author Andrey
 */
public class MoneyDeserializer extends StdDeserializer<Money> {

    public MoneyDeserializer() {
        this(null);
    }

    public MoneyDeserializer(Class<Money> vc) {
        super(vc);
    }

    @Override
    public Money deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        String value = jp.getText();
        if (value == null) {
            return null;
        }
        String[] values = value.split(" ");
        if (values.length != 2) {
            throw dc.instantiationException(Money.class, "Bad value " + value);
        }
        return new Money(new BigDecimal(values[0]), Currency.getInstance(values[1]));
    }

}
