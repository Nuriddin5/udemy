package com.nuriddin.courseforuser.projection;

import com.nuriddin.courseforuser.entity.enums.CourseStatus;

import java.util.List;
import java.util.UUID;

public interface CourseProjection {
    Long getId();

    String getName();

    Double getPrice();

    String getHeadline();

    Long getPhotoId();

    Float getAvgRating();

    CourseStatus getStatus();

    List<UsersCoursesInfo> getInstructors();

    interface UsersCoursesInfo {

        UUID getInstructorId();
    }
}
