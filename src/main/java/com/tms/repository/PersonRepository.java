package com.tms.repository;

import com.tms.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Modifying
    @Query("update person p set p.age = :age where p.id = :id")
    void updateAgeById(Integer age, Long id);

    List<Person> findAllByAge(Integer age);
}