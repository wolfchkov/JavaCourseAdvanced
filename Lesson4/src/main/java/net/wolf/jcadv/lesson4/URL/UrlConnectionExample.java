/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson4.URL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

/**
 * Получение JSON ответа с помощью URLConnection
 * @author Andrey
 */
public class UrlConnectionExample {

    private static final String WEATHER_SERVICE = "http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1";

    public static String createPost(String post) throws IOException {
        //Создаем наш URL
        URL serviceURL = new URL(WEATHER_SERVICE);

        //Получаем HttpURLConnection
        HttpURLConnection connection = (HttpURLConnection) serviceURL.openConnection();
        //метод 'GET'
        connection.setRequestMethod("GET");
        
        connection.connect();
        System.out.println("Заголовки ответа:  ");
        connection.getHeaderFields().forEach((k, v) -> System.out.format("\t %s: %s%n", k , v));
                
        
        try ( BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); ) {
            //читаем весь ответ
            return reader
                    .lines()
                    .collect(Collectors.joining("\n"));

        }

    }

    public static void main(String[] args) throws IOException {
        String res = createPost("test");
        System.out.println(res);
    }
}
