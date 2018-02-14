package com.cardealers.cardealers.repository;

import com.cardealers.cardealers.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrand(String brandName);

    List<Car> findByBrandAndModel(String brand, String model);
}
