package com.nuriddin.my_teaching_project_like_udemy.repository;


import com.nuriddin.my_teaching_project_like_udemy.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Long> {
    List<Course> findAllByCategoryId(Long category_id);


    Course findByPathName(String pathName);

    @Query(nativeQuery = true,
            value = "select *\n" +
                    "from course\n" +
                    "where lower(name) like lower(concat('%', :query, '%'))"
    )
    List<Course> findCourseForSearch(String query);

//    public List<Course> findAllByCategoryId;
}
