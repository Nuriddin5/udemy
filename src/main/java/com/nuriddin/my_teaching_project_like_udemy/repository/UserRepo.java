package com.nuriddin.my_teaching_project_like_udemy.repository;


import com.nuriddin.my_teaching_project_like_udemy.entity.Lesson;
import com.nuriddin.my_teaching_project_like_udemy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {

}
