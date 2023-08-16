package com.tms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            //Регистрация драйвера
            Class.forName("org.postgresql.Driver");

            //Создать соединение
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/group-67-database", "postgres", "root");

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
