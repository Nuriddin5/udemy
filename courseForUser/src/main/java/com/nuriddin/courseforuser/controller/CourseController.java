package com.nuriddin.courseforuser.controller;

import com.nuriddin.courseforuser.service.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public record CourseController(
        CourseService courseService
) {

    @GetMapping("/course")
    public HttpEntity<?> getAllCourses(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sort,
            @RequestParam(defaultValue = "true") boolean direction
    ) {

        Page allCourses = courseService.getAllCourses(page, size, sort, direction);
        return ResponseEntity.ok(allCourses);
    }


}
