package com.nuriddin.courseforuser.dto;

import com.nuriddin.courseforuser.entity.UsersCourses;
import com.nuriddin.courseforuser.entity.enums.CourseStatus;

import java.util.List;

public class CourseDto {

    String name;

    Double price;

    List<UsersCourses> instructors;

    String headline;

    Long photoId;


    // TODO: 21.04.2022 write query
    float avgRating;

    CourseStatus status;

}
