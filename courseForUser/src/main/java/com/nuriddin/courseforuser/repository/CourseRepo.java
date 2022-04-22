package com.nuriddin.courseforuser.repository;


import com.nuriddin.courseforuser.entity.Course;
import com.nuriddin.courseforuser.projection.CourseProjection;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface CourseRepo extends JpaRepository<Course, Long> {

    @Query(nativeQuery = true,value =
            "select c.id, name, price, headline, photo_id, avg_rating, status from public.course c")
    Page<CourseProjection> getAllCourses(Pageable pageable);

    @Query(nativeQuery = true, value = "select instructorId from users_courses where courseId = :courseId")
    List<UUID> getCourseInstructors(Long courseId);
}
