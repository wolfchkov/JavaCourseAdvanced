/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author Andrey
 */
public class ValidatorEngine {
 
        public void validate(Object obj) throws IllegalArgumentException, IllegalAccessException {
                if ( Objects.nonNull(obj) ) {
                        Class<?> vClass = obj.getClass();
                        
                        Field[] fields = vClass.getDeclaredFields();
                        for (Field field : fields) {
                                validateField(field, obj);                                
                        }
                }
        }

        private void validateField(Field field, Object obj) throws IllegalArgumentException, IllegalAccessException {
                
                Annotation[] annotations = field.getAnnotations();
                
                for (Annotation annotation : annotations) {
                        if (annotation.annotationType() == PatternCheck.class) {
                                PatternCheck patternCheck  = (PatternCheck) field.getAnnotation(annotation.annotationType());
                                if (!field.isAccessible()) {
                                        field.setAccessible(true);
                                }
                                Object value = field.get(obj);
                                
                                if (Objects.nonNull(value)) {
                                        Pattern regex = Pattern.compile(patternCheck.value());
                                        if (!regex.matcher( (CharSequence) value).matches() ) {
                                                System.out.printf("Ошибка валидации значения '%s': %s %n",  value, patternCheck.message());   
                                        }
                                }
                                
                        }
                }
        }
        
        public static void main(String[] args) {
                try {
                        ValueObject valueObject = new ValueObject("A_NDREY", "+380555468509353");
                        ValidatorEngine engine = new ValidatorEngine();
                        engine.validate(valueObject);
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                        ex.printStackTrace();
                }
        }
}
