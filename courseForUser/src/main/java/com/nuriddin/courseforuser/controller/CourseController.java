package com.nuriddin.courseforuser.controller;

import com.nuriddin.courseforuser.service.CourseService;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public record CourseController(
        CourseService courseService
) {

    @GetMapping("/course")
    public HttpEntity<?> getAllCourses() {

//        courseService.getAllCourses()
        return null;
    }
}
