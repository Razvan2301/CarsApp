package com.cardealers.cardealers.controller;

import com.cardealers.cardealers.model.Car;
import javafx.application.Application;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class IndexController {
	@GetMapping
	public String index() {
		return "index";
	}

	@GetMapping("/cars")
	public String cars(Model model) {
		Car car = Car.builder().model("Series 7").brand("BMW").cubicCapacity(4000D).price(200000D).build();
		model.addAttribute("car", car);
		return "cars";
	}


	@GetMapping("/car/add")
	public String getPostForm(Model model) {
		model.addAttribute("car", new Car());
		return "car_form";
	}

	@PostMapping(value = "/car/add")
	public String postCar(@RequestBody Car car) {
		return "success_car";
	}

	@PostMapping("/test")
	public String postTest(@RequestBody String test) {
		return "success_car";
	}

	@GetMapping("/test")
	public String getTest() {
		return "test";
	}

}
