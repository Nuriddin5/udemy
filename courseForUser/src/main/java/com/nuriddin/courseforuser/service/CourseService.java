package com.nuriddin.courseforuser.service;

import com.nuriddin.courseforuser.repository.CourseRepo;
import org.springframework.stereotype.Service;

@Service
public record CourseService(CourseRepo courseRepo) {


//    public List<CourseDto> getAllCourses() {
//
//    }
}
