package com.nuriddin.courseforuser.repository;


import com.nuriddin.courseforuser.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {

//    @Query(nativeQuery = true,value =
//    "select * from cour")
//    Page<CourseProjection> getAllCourses(Pageable pageable);
}
