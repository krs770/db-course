package ru.mpei.springdata.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.mpei.springdata.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findAllByAgeIsGreaterThan(Integer age);
}
