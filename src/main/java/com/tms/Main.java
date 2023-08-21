package com.tms;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        final String SQL = "INSERT INTO person(id,first_name,second_name,age,is_married, created)" +
                "VALUES (DEFAULT,?,?,?,?,?)";
        try {
            // Регистрация драйвера
            Class.forName("org.postgresql.Driver");

            // Создать соединение
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/group-67-database", "postgres", "root");

            // Выбираем один из стейтментов и делаем запрос
            PreparedStatement statement = connection.prepareStatement(SQL);

            // Донастройка запроса
            statement.setString(1, "Dima");
            statement.setString(2, "Dima");
            statement.setInt(3, 18);
            statement.setBoolean(4, true);
            statement.setDate(5, new Date(System.currentTimeMillis()));

            //Отправка
            int result = statement.executeUpdate();
            System.out.println(result);
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
