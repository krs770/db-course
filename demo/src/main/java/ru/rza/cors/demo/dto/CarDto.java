package ru.rza.cors.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarDto {
    private Integer id;
    private String name;
    private String ownerName;
}
