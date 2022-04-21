package com.nuriddin.my_teaching_project_like_udemy.repository;


import com.nuriddin.my_teaching_project_like_udemy.entity.Answer;
import com.nuriddin.my_teaching_project_like_udemy.entity.LessonStatusForUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonStatusForUserRepo extends JpaRepository<LessonStatusForUser, Long> {
}
