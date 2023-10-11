package com.tms.repository;

import com.tms.domain.Person;
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

    public List<Person> getAll() {
        Query<Person> query = session.createQuery("from person", Person.class);
        return query.getResultList();
    }

    public Optional<Person> getPersonById(Long id) {
        return Optional.ofNullable(session.get(Person.class, id));
    }

    public Boolean create(Person person) {
        try {
            session.getTransaction().begin();
            session.persist(person);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.warn("We have problem with creation person:" + person + ". The ex: " + e);
        }
        return false;
    }

    public Boolean update(Person person) {
        try {
            session.getTransaction().begin();
            session.merge(person);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.warn("We have problem with updating person:" + person + ". The ex: " + e);
        }
        return false;
    }

    public void deleteById(Long id) {
        try {
            session.getTransaction().begin();
            session.remove(getPersonById(id).get());
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.warn("We have problem with deleting person with id:" + id + ". The ex: " + e);
        }
    }
}
