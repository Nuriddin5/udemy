package com.nuriddin.courseforuser.repository;


import com.nuriddin.courseforuser.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepo extends JpaRepository<Lesson, Long> {
}
