/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson3.reflection;

import static java.lang.System.out;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.wolf.jcadv.lesson3.ValueObject;

/**
 * Класс который может нам показать много информации о любом другом классе.
 *
 * @author Andrey
 */
public class ClassInformer extends AbstractInformer {

        private final Set<AbstractInformer> informers = new LinkedHashSet<>();

        public ClassInformer() {
                informers.add(new FieldsInformer());
                informers.add(new MethodInformer());
        }

        private void aboutTypeParameters(Class<?> klass) {
                TypeVariable<? extends Class<?>>[] typeParameters = klass.getTypeParameters();
                if (typeParameters.length != 0) {
                        out.format("\tОбобщения: %s;%n",
                                Stream.of(typeParameters)
                                        .map(TypeVariable::toString)
                                        .collect(Collectors.joining(", ")));
                } else {
                        out.format("\tНе содержит обобщений (generics);%n");
                }
        }

        private void aboutSuperclass(Class<?> klass) {
                Class<?> superclass = klass.getSuperclass();
                if (Objects.nonNull(superclass)) {
                        out.format("\tНаследует класс: %s;%n", superclass.getName());
                } else {
                        out.format("\tНе наследует класс;%n");
                }
        }

        private void aboutGenericInterfaces(Class<?> klass) {
                Type[] intfs = klass.getGenericInterfaces();
                if (intfs.length != 0) {
                        out.format("\tРеализует интерфейс(ы): %s; %n",
                                Stream.of(intfs)
                                        .map(Type::getTypeName)
                                        .collect(Collectors.joining(", ")));
                } else {
                        out.format("\tНе реализует интерфейс(ы);%n");
                }
        }

        private void aboutAnnotation(Class<?> klass) {
                Annotation[] annotations = klass.getAnnotations();
                if (annotations.length != 0) {
                        out.format("\tАннотация(и): %s;%n",
                                Stream.of(annotations)
                                        .map(Annotation::toString)
                                        .collect(Collectors.joining(", ")));
                } else {
                        out.format("\tАннотации отсутсвуют;%n");
                }
        }

        @Override
        public void tellAbout(final Class<?> klass) {
                out.format("Информация о классе '%s': %n", klass.getName());
                out.format("\tОбъявлен с модификатором(ами): %s;%n", Modifier.toString(klass.getModifiers()));

                aboutTypeParameters(klass);

                aboutSuperclass(klass);

                aboutGenericInterfaces(klass);

                aboutAnnotation(klass);

                informers.forEach((t) -> {
                        t.tellAbout(klass);
                });
        }

        public void tellAbout(String className) {
                try {
                        Class<?> klass = Class.forName(className);
                        tellAbout(klass);
                } catch (ClassNotFoundException ex) {
                        System.err.println("Извените, но класс '" + className + "' не найден!");
                }

        }

        public static void main(String[] args) {
                new ClassInformer().tellAbout(ValueObject.class);
        }

}
