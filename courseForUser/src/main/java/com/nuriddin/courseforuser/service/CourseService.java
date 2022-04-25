package com.nuriddin.courseforuser.service;

import com.nuriddin.courseforuser.dto.CourseDto;
import com.nuriddin.courseforuser.entity.Course;
import com.nuriddin.courseforuser.projection.CourseProjection;
import com.nuriddin.courseforuser.repository.CourseRepo;
import org.springframework.data.domain.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public record CourseService(CourseRepo courseRepo) {
    public Page getAllCourses(int page, int size, String sort, boolean direction) {
        Pageable pageable = PageRequest.of(page-1,size,direction? Sort.Direction.ASC : Sort.Direction.DESC, sort);
        Page<CourseProjection> allCourses = courseRepo.getAllCourses(pageable);
        return allCourses;
    }


    public HttpEntity saveCourse(CourseDto courseDto) {
        Course course = new Course();
        course.setName(courseDto.getName());
        course.setPrice(courseDto.getPrice());

        courseRepo().save(course);
        return ResponseEntity.ok("success");
    }
}
