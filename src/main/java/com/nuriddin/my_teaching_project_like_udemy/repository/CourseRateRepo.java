package com.nuriddin.my_teaching_project_like_udemy.repository;


import com.nuriddin.my_teaching_project_like_udemy.entity.CourseRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRateRepo extends JpaRepository<CourseRate, Long> {
}
