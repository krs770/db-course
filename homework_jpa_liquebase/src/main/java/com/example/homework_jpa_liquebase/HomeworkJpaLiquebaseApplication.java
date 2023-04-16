package com.example.homework_jpa_liquebase;

import com.example.homework_jpa_liquebase.repository.ResultRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HomeworkJpaLiquebaseApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(HomeworkJpaLiquebaseApplication.class, args);

        ResultRepository repository = context.getBean(ResultRepository.class);

        System.out.println(repository.getResult());
    }

}
