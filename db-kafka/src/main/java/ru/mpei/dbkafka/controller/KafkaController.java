package ru.mpei.dbkafka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mpei.dbkafka.produser.TopicProducer;

@RequiredArgsConstructor
@RequestMapping(value = "/kafka")
@RestController
public class KafkaController {
    
    private final TopicProducer topicProducer;
    
    @GetMapping(value = "/send")
    public void send(){
        topicProducer.send("test message");
    }
}
