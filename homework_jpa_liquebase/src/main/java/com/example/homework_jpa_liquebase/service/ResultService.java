package com.example.homework_jpa_liquebase.service;

import com.example.homework_jpa_liquebase.entity.Result;
import com.example.homework_jpa_liquebase.repository.ResultRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ResultService {

    private ResultRepository resultRepository;

    public List<Result> getResult() {
        return resultRepository.getResult();
    }
}
