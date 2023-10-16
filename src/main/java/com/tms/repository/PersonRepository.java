package com.tms.repository;

import com.tms.domain.Person;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class PersonRepository {

    public final Session session;

    public PersonRepository(Session session) {
        this.session = session;
    }

    //READ ALL
    public List<Person> getAll() {
        Query<Person> query = session.createQuery("from person", Person.class);
        return query.getResultList();
    }

    //READ BY ID
    public Optional<Person> getPersonById(Long id) {
        Query<Person> query = session.createQuery("from person p where p.id=:userId", Person.class);
        query.setParameter("userId", id);
        return Optional.ofNullable(query.getSingleResult());
    }

    //CREATE
    public Boolean create(Person person) {
        /*      Не предназначена для добавления строк, только из других таблиц*/
        try {
            session.beginTransaction();

            Query query = session.createQuery("INSERT INTO person (firstName, secondName, created, isMarried, role) " +
                    "SELECT firstName, secondName, created, isMarried, role FROM person _second");
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.warn("We have problem with creation person:" + person + ". The ex: " + e);
        }
        return false;
    }

    //UPDATE
    public Boolean update(Person person) {
        try {
            Query<Person> query = session.createQuery("update person set firstName=:firstName,secondName=:secondName, " +
                    "age=:age,isMarried=:isMarried,role=:role where id=:id");
            query.setParameter("firstName", person.getFirstName());
            query.setParameter("secondName", person.getSecondName());
            query.setParameter("age", person.getAge());
            query.setParameter("isMarried", person.getIsMarried());
            query.setParameter("role", person.getRole());
            query.setParameter("id", person.getId());
            session.getTransaction().begin();
            query.executeUpdate();
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.warn("We have problem with updating person:" + person + ". The ex: " + e);
        }
        return false;
    }

    //DELETE
    public void deleteById(Long id) {
        try {
            Query<Person> query = session.createQuery("delete from person where id=:id");
            query.setParameter("id", id);

            session.getTransaction().begin();
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.warn("We have problem with deleting person with id:" + id + ". The ex: " + e);
        }
    }
}
