package com.cardealers.cardealers;

import com.cardealers.cardealers.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cardealers.cardealers.repository.CarRepository;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CardealersApplication {

	@Autowired
	private CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(CardealersApplication.class, args);
		}

	@Bean
	CommandLineRunner commandLineRunner () {
		return (args) -> {
			carRepository.save(
					Car.builder().brand("bmw")
							.model("serie 7")
							.cubicCapacity(2000D)
							.fabricationYear(2010)
							.price(20000D)
							.build()
			);
			carRepository.save(
					Car.builder().brand("audi")
							.model("a7")
							.cubicCapacity(3000D)
							.fabricationYear(2017)
							.price(100000D)
							.build()
			);
			carRepository.save(
					Car.builder().brand("bmw")
							.model("serie 7")
							.cubicCapacity(5000D)
							.fabricationYear(2014)
							.price(50000D)
							.build()
			);
			carRepository.save(
					Car.builder().brand("audi")
							.model("a4")
							.cubicCapacity(2000D)
							.fabricationYear(2011)
							.price(14000D)
							.build()
			);
		};
	}
	}
