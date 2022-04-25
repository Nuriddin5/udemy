package com.nuriddin.courseforuser.controller;

import com.nuriddin.courseforuser.dto.CourseDto;
import com.nuriddin.courseforuser.entity.Course;
import com.nuriddin.courseforuser.service.CourseService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")

public record CourseController(
        CourseService courseService
) {

    @GetMapping
    public HttpEntity<?> getAllCourses(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sort,
            @RequestParam(defaultValue = "true") boolean direction
    ) {
        Page allCourses = courseService.getAllCourses(page, size, sort, direction);
        return ResponseEntity.ok(allCourses);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getCourse(@PathVariable String id) throws ChangeSetPersister.NotFoundException {
        Course course = courseService.courseRepo().findById(Long.valueOf(id)).orElseThrow(ChangeSetPersister.NotFoundException::new);
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public HttpEntity<?> saveCourse(@RequestBody CourseDto courseDto) {
        return courseService.saveCourse(courseDto);
    }



    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteCourse(@PathVariable String id) {
        courseService.courseRepo().deleteById(Long.valueOf(id));
        return ResponseEntity.ok("success");
    }

}
