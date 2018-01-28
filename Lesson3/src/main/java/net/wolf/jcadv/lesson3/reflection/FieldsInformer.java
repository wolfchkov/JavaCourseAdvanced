/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson3.reflection;

import static java.lang.System.out;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 *
 * @author Andrey
 */
public class FieldsInformer extends AbstractInformer {

        @Override
        public void tellAbout(Class<?> klass) {

                Field[] fields = klass.getDeclaredFields();

                out.format("Поля класса:%n");

                for (Field field : fields) {
                        aboutField(field);
                }
        }

        private void aboutField(Field field) {

                out.format("\tПоле '%s';%n", field.getName());

                out.format("\t\tМодификаторы %s;%n", Modifier.toString(field.getModifiers()));

                out.format("\t\tТип поля %s;%n", field.getType().getName());
        }

        public static void main(String[] args) throws ClassNotFoundException {

                Class<?> klass = Class.forName("java.lang.String");
                
                new FieldsInformer().tellAbout(klass);

        }
}
