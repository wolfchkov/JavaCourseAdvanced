/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson7;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 *
 * @author Andrey
 */
public class ListCollectionsDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        // оборачиваем стандратный список в ObservableList
        ObservableList<String> observableList = FXCollections.observableList(list);
        observableList.addListener((ListChangeListener.Change<? extends String> change) ->
                System.out.println("Зафиксированно изменение!")
         );

        // Данное изменение будет зарегистрированно
        observableList.add("item one");

        // Данное изменение НЕ будет зарегистрированно
        list.add("item two");

        System.out.println("Size: " + observableList.size());
    }
}
