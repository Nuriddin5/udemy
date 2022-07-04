package com.nuriddin.my_teaching_project_like_udemy.service;


import com.nuriddin.my_teaching_project_like_udemy.dto.UserRegistrationDto;
import com.nuriddin.my_teaching_project_like_udemy.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);
}
