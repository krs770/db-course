package ru.rza.cors.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.rza.cors.demo.entity.CarEntity;

public interface CarRepository extends JpaRepository<CarEntity, Long > {
    List<CarEntity> findAllByOwnerName(String ownerName);
}
