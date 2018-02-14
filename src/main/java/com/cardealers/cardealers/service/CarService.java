package com.cardealers.cardealers.service;

import com.cardealers.cardealers.model.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.cardealers.cardealers.repository.CarRepository;
import org.springframework.ui.Model;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public Car getCarById(Long id) {
        return carRepository.findOne(id);
    }

    public List<Car> findByBrandName(String brandName) {
       return carRepository.findByBrand(brandName);
    }

    public List<Car> findByBrandNameAndModel(String brand, String model) {
        return carRepository.findByBrandAndModel(brand, model);
    }
}
