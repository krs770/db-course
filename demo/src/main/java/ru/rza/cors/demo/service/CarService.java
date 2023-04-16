package ru.rza.cors.demo.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rza.cors.demo.dto.CarDto;
import ru.rza.cors.demo.repository.CarRepository;

@Service
@AllArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    @Transactional(readOnly = true)
    public List<CarDto> getAll() {
        return carRepository.findAll().stream().map(
            entity -> new CarDto(entity.getId(), entity.getName(), entity.getOwnerName())
        ).toList();
    }

}
