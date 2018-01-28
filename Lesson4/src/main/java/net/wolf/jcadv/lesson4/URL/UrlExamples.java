/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson4.URL;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Примеры конструкторов java.net.URL
 *
 * @author Andrey
 */
public class UrlExamples {

    public static void construct() {
        try {
            URL myURL = new URL("http://example.com/");
            System.out.println(myURL);
        } catch (MalformedURLException ex) {
            System.out.println("Неверный URL: " + ex.getMessage());
        }

        try {
            URL myURL = new URL("http://example.com/");

            URL myURL1 = new URL(myURL, "/some/resource1");
            URL myURL2 = new URL(myURL, "/some/resource2");
            System.out.println(myURL1);
            System.out.println(myURL2);
        } catch (MalformedURLException ex) {
            System.out.println("Неверный URL: " + ex.getMessage());
        }

        try {
            URL myURL = new URL("http", "example.com", 80, "pages/page1.html");
            System.out.println(myURL);
        } catch (MalformedURLException ex) {
            System.out.println("Неверный URL: " + ex.getMessage());
        }

        try {
            URL myURL = new URL("blabla://example.com");
            System.out.println(myURL);
        } catch (MalformedURLException ex) {
            System.out.println("Неверный URL: " + ex.getMessage());
        }
    }

    public static void parsing(String url) {
        try {
            URL aURL = new URL(url);
            System.out.println("протокол = " + aURL.getProtocol());
            System.out.println("авторизация = " + aURL.getAuthority());
            System.out.println("хост = " + aURL.getHost());
            System.out.println("порт = " + aURL.getPort());
            System.out.println("путь = " + aURL.getPath());
            System.out.println("запрос = " + aURL.getQuery());
            System.out.println("имя файла = " + aURL.getFile());
            System.out.println("референс = " + aURL.getRef());
        } catch (MalformedURLException ex) {
            System.out.println("Неверный URL: " + ex.getMessage());
        }

    }

    public static void main(String[] args) {
        parsing("https://www.google.com.ua/search?q=java+URL&oq=java+URL&aqs=chrome..69i57j69i60l3j0l2.508j0j9&sourceid=chrome&ie=UTF-8");
    }
}
