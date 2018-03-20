/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson6.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Andrey
 */
public class JDBCExample {

    public static void createTables(Connection connection) throws SQLException {
        //полкючаемся к БД
        try (Statement statement = connection.createStatement();) {

            //создаем таблицы
            statement.execute(QueryHolder.getInstance().getQuery("table.client"));
            statement.execute(QueryHolder.getInstance().getQuery("table.phone"));
        }
    }

    public static void insert(Connection connection, int id, String firstName, String lastName, String address) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(QueryHolder.getInstance().getQuery("insert.client"));) {
            statement.setInt(1, id);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, address);

            statement.execute();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //полкючаемся к БД
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test");) {
            //создаем таблицы
            createTables(connection);

            //Заполняем данными клиентов
            insert(connection, 1, "John", "Snow", "USA, New Yourk");
            insert(connection, 2, "Petr", "Petrov", "Ukraine, Kiev");
            insert(connection, 3, "Ivan", "Ivanov", "Ukraine, Dnepr");

            PreparedStatement ps = connection.prepareStatement(QueryHolder.getInstance().getQuery("select.client"));
            ps.setInt(1, 1);
            try (ResultSet resultSet = ps.executeQuery();) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1));
                    System.out.println(resultSet.getString(2));
                    System.out.println(resultSet.getString(3));
                    System.out.println(resultSet.getString(4));
                }
            }

        }

    }
}
