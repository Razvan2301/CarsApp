package com.cardealers.cardealers.controller;

import com.cardealers.cardealers.model.Car;
import com.cardealers.cardealers.model.User;
import com.cardealers.cardealers.service.CarService;
import com.cardealers.cardealers.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequestMapping("/")
@Controller
@AllArgsConstructor
public class IndexController {
	private final CarService carService;
	private final UserService userService;
	@GetMapping
	public String index(Model model) {
		model.addAttribute("cars", carService.getAll());
		return "main_search";
	}

	@GetMapping("/cars")
	public String cars(Model model) {
		//Car car = Car.builder().model("Series 7").brand("BMW").cubicCapacity(4000D).price(200000D).build();
		model.addAttribute("cars", carService.getAll());
		return "cars";
	}

	@GetMapping("/car/edit/{id}")
	public String cars(Model model, @PathVariable String id){
		System.out.print(id);
		model.addAttribute("car", carService.getCarById(Long.valueOf(id)));
		return "car_edit";
	}


	@GetMapping("/car/add")
	public String getPostForm(Model model, Principal principal) {
		Car car = new Car();
		car.setId(0L);
		model.addAttribute("user", principal.getName());
		model.addAttribute("car", car);
		System.out.print("Car ID " + car.getId());
		return "car_form";
	}

	@PostMapping(value = "/car/add")
	public String postCar(@ModelAttribute Car car) {
		carService.saveCar(car);
		return "redirect:/cars";
	}

	@PostMapping("/car/edit/{id}")
	public String doEdit(@ModelAttribute Car car, @PathVariable String id) {
		car.setId(Long.valueOf(id));
		carService.saveCar(car);
		return "redirect:/cars";
	}

	@PostMapping("/test")
	public String postTest(@RequestBody String test) {
		return "success_car";
	}

	@GetMapping("/test")
	public String getTest() {
		return "test";
	}

	@GetMapping("/search")
	public String searchResultByName(@RequestParam String brandName, Model model) {
		model.addAttribute("cars", carService.findByBrandName(brandName));
		return "cars";
	}

	@GetMapping("/advanced/search")
	public String advancedSearch(@RequestParam String brand, @RequestParam("model") String carModel, Model model) {
		model.addAttribute("cars", carService.findByBrandNameAndModel(brand, carModel));
		return "cars";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String doRegister(@ModelAttribute User user) {
		userService.save(user);
		return "redirect:/login";
	}
}
