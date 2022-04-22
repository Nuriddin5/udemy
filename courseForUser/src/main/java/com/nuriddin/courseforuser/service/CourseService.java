package com.nuriddin.courseforuser.service;

import com.nuriddin.courseforuser.projection.CourseProjection;
import com.nuriddin.courseforuser.repository.CourseRepo;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public record CourseService(CourseRepo courseRepo) {
    public Page getAllCourses(int page, int size, String sort, boolean direction) {
        Pageable pageable = PageRequest.of(page-1,size,direction? Sort.Direction.ASC : Sort.Direction.DESC, sort);
        Page<CourseProjection> allCourses = courseRepo.getAllCourses(pageable);
        return allCourses;
    }



}
