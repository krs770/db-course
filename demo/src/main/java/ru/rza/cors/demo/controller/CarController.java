package ru.rza.cors.demo.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rza.cors.demo.dto.CarDto;
import ru.rza.cors.demo.service.CarService;

@RequestMapping("/api")
@Controller
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/all")
    public ResponseEntity<List<CarDto>> getHello() {
        return ResponseEntity.ok(carService.getAll());
    }


}
