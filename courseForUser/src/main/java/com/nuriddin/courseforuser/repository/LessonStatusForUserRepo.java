package com.nuriddin.courseforuser.repository;


import com.nuriddin.courseforuser.entity.LessonStatusForUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonStatusForUserRepo extends JpaRepository<LessonStatusForUser, Long> {
}
