package ru.mpei.springdata;

import lombok.SneakyThrows;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.mpei.springdata.domain.Person;
import ru.mpei.springdata.repository.PersonRepository;


@SpringBootApplication
public class Main {


    @SneakyThrows
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class);
        PersonRepository personRepository = context.getBean(PersonRepository.class);
//        EmailRepository emailRepository = context.getBean(EmailRepository.class);


         personRepository.save(new Person("Александр Сергеевич Пушкин", 20));
         personRepository.save(new Person("Михаил Юрьевич Лермонтов", 60));
         personRepository.save(new Person("Михаил Сергеевич Горбачев", 31));


        Iterable<Person> all = personRepository.findAllByAgeIsGreaterThan(49);
        System.out.println(all);

        System.out.println(personRepository.count());
        Console.main(args);
    }


}
