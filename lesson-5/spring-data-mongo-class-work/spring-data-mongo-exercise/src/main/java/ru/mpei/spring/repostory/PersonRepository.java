package ru.mpei.spring.repostory;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.repository.CrudRepository;
import ru.mpei.spring.domain.Person;

import java.util.List;


public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person> findAll();
}
