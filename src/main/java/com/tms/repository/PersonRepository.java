package com.tms.repository;

import com.tms.domain.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

@Slf4j
@Repository
public class PersonRepository {

    public final EntityManager entityManager;

    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Person> getAll() {
        Query query = entityManager.createQuery("from person"); //JPQL
        return query.getResultList();
    }

    public Optional<Person> getPersonById(Long id) {
        return Optional.ofNullable(entityManager.find(Person.class, id));
    }

    public Boolean create(Person person) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(person);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            log.warn("We have problem with creation person:" + person + ". The ex: " + e);
        }
        return false;
    }

    public Boolean update(Person person) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(person);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            log.warn("We have problem with updating person:" + person + ". The ex: " + e);
        }
        return false;
    }

    public Boolean deleteById(Long id) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(getPersonById(id).get());
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            log.warn("We have problem with deleting person with id:" + id + ". The ex: " + e);
        }
        return false;
    }
}
