/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson3.reflection;

import static java.lang.System.out;
import java.lang.annotation.Annotation;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Andrey
 */
public abstract class AbstractInformer {

        public abstract void tellAbout(Class<?> klass);

        protected void aboutAnnotation(String prefix, Annotation[] annotations) {               
                if (annotations.length != 0) {
                        out.format("%sАннотация(и): %s;%n", prefix, 
                                Stream.of(annotations)
                                        .map(Annotation::toString)
                                        .collect(Collectors.joining(", ")));
                } else {
                        out.format("%sАннотации отсутсвуют;%n", prefix);
                }
        }
}
