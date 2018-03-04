/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson6.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Andrey
 */
public class JDBCExample {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //загружаем драйвер
        Class.forName("org.h2.Driver");

        //полкючаемся к БД
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test");) {
            QueryHolder queryHolder = QueryHolder.getInstance();
            Statement statement = connection.createStatement();
            statement.execute(queryHolder.getQuery("table.client"));
            statement.execute(queryHolder.getQuery("table.phone"));
        }

    }
}
