package com.tms.repository;

import com.tms.domain.Person;
import com.tms.domain.Role;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<Person> getPersonById(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE id=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return Optional.of(sqlParser(resultSet));
        } catch (SQLException e) {
            System.out.println(e);
        }
        return Optional.empty();
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

    public Boolean create(Person person) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into person(id,first_name,second_name,age,is_married,created)" + "VALUES (default,?,?,?,?,?)");
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getSecondName());
            statement.setInt(3, person.getAge());
            statement.setBoolean(4, person.getIsMarried());
            statement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public Boolean update(Person person) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE person SET first_name = ?, second_name = ?,age = ?,is_married = ?,created = ? WHERE id = ?");
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getSecondName());
            statement.setInt(3, person.getAge());
            statement.setBoolean(4, person.getIsMarried());
            statement.setTimestamp(5, person.getCreated());
            statement.setLong(6, person.getId());
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public Boolean deleteById(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM person WHERE id= ?");
            statement.setLong(1, id);
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
}
