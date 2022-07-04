package com.nuriddin.my_teaching_project_like_udemy.controllers;


import com.nuriddin.my_teaching_project_like_udemy.dto.UserRegistrationDto;
import com.nuriddin.my_teaching_project_like_udemy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class
UserRegistrationController {

	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "register";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") @RequestBody UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/register";
	}
}
