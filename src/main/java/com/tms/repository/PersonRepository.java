package com.tms.repository;

import com.tms.domain.Person;
import com.tms.domain.Role;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    Connection connection;

    {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/group-67-database", "postgres", "root");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> getAll() {
        if (true){
            throw new RuntimeException();
        }
        List<Person> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM person");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Person person = sqlParser(resultSet);
                list.add(person);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Person getPersonById(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE id=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return sqlParser(resultSet);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return new Person();
    }

    public Person sqlParser(ResultSet result) throws SQLException {
        Person person = new Person();
        person.setId(result.getLong("id"));
        person.setFirstName(result.getString("first_name"));
        person.setSecondName(result.getString("second_name"));
        person.setAge(result.getInt("age"));
        person.setIsMarried(result.getBoolean("is_married"));
        person.setCreated(result.getTimestamp("created"));
        return person;
    }
}
