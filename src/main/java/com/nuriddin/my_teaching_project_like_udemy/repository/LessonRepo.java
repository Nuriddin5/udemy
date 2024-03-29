package com.nuriddin.my_teaching_project_like_udemy.repository;


import com.nuriddin.my_teaching_project_like_udemy.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LessonRepo extends JpaRepository<Lesson, Long> {

    List<Lesson> findAllByModuleId(Long module_id);

    Optional<Lesson> findById(Long id);



}
