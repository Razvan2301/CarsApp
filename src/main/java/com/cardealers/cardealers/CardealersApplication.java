package com.cardealers.cardealers;

import com.cardealers.cardealers.model.Car;
import com.cardealers.cardealers.model.User;
import com.cardealers.cardealers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cardealers.cardealers.repository.CarRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CardealersApplication {

	@Autowired
	private CarRepository carRepository;
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CardealersApplication.class, args);
		}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner commandLineRunner () {
		return (args) -> {
			userRepository.save(
					User.builder()
						.email("a@a.ro")
						.password(bCryptPasswordEncoder().encode("a"))
						.build()
			);
			userRepository.save(
					User.builder()
							.email("aa@a.ro")
							.password(bCryptPasswordEncoder().encode("a"))
							.build()
			);

			userRepository.save(
					User.builder()
							.email("aaa@a.ro")
							.password(bCryptPasswordEncoder().encode("a"))
							.build()
			);

			userRepository.save(
					User.builder()
							.email("aaaa@a.ro")
							.password(bCryptPasswordEncoder().encode("a"))
							.build()
			);


			carRepository.save(
					Car.builder().brand("bmw")
							.model("serie 7")
							.cubicCapacity(2000D)
							.fabricationYear(2010)
							.price(20000D)
							.user(userRepository.findOne(1L))
							.build()
			);
			carRepository.save(
					Car.builder().brand("audi")
							.model("a7")
							.cubicCapacity(3000D)
							.fabricationYear(2017)
							.price(100000D)
							.user(userRepository.findOne(1L))
							.build()
			);
			carRepository.save(
					Car.builder().brand("bmw")
							.model("serie 7")
							.cubicCapacity(5000D)
							.fabricationYear(2014)
							.price(50000D)
							.user(userRepository.findOne(1L))
							.build()
			);
			carRepository.save(
					Car.builder().brand("audi")
							.model("a4")
							.cubicCapacity(2000D)
							.fabricationYear(2011)
							.price(14000D)
							.user(userRepository.findOne(1L))
							.build()
			);
		};
	}
	}
