/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson7;

import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;

/**
 *
 * @author Andrey
 */
public class MapCollectionsDemo {

    public static void main(String[] args) {

        // Создадим стандартную карту
        Map<String, String> map = new HashMap<>();

        // обернем ее в ObservableMap
        ObservableMap<String, String> observableMap = FXCollections.observableMap(map);
        observableMap.addListener((MapChangeListener.Change<? extends String, ? extends String> change) -> 
            System.out.println("Изменение зафиксированно!")
        );

        // Это изменение будет зафиксированно
        observableMap.put("key 1", "value 1");
        System.out.println("Size: " + observableMap.size());

        // Это изменение НЕ будет зафиксированно
        map.put("key 2", "value 2");
        System.out.println("Size: " + observableMap.size());
    }
}
