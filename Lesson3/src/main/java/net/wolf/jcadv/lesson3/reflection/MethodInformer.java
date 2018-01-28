/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson3.reflection;

import static java.lang.System.out;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Andrey
 */
public class MethodInformer  extends AbstractInformer {

        @Override
        public void tellAbout(Class<?> klass) {
                out.format("Методы класса:%n");

                Method[] methods = klass.getDeclaredMethods();
                for (Method method : methods) {
                        aboutMethod(method);
                }
        }

        private void aboutMethod(Method method) {
                out.format("\tМетод '%s';%n", method.getName());
                
                out.format("\t\tМодификаторы %s;%n", Modifier.toString(method.getModifiers()));

                out.format("\t\tТип возвращаемого значения %s;%n", method.getReturnType().getName());
                
                 aboutAnnotation("\t\t", method.getAnnotations());                
                
                 Parameter[] parameters = method.getParameters();
                 aboutParameters(parameters);
                Class<?>[] exceptionTypes = method.getExceptionTypes();
                aboutExceptions(exceptionTypes);

        }

        private void aboutParameters(Parameter[] parameters) {
                 out.format("\t\tПараметры метода: %s;%n", 
                         Stream.of(parameters)
                                .map(Parameter::toString)
                                .collect(Collectors.joining(","))
                         );
        }
        
        private void aboutExceptions(Class<?>[] exceptionTypes) {
                 out.format("\t\tИсключения: %s;%n", 
                         Stream.of(exceptionTypes)
                                .map(Class::toString)
                                .collect(Collectors.joining(","))
                         );
        }

        public static void main(String[] args) throws ClassNotFoundException {
                 Class<?> klass = Class.forName("java.lang.String");
                
                new MethodInformer().tellAbout(klass);
        }
}
