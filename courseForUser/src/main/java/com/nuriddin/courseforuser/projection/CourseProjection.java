package com.nuriddin.courseforuser.projection;

import com.nuriddin.courseforuser.entity.enums.CourseStatus;
import org.springframework.beans.factory.annotation.Value;

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

    @Value("#{@courseRepo.getCourseInstructors(target.id)}")
    List<UUID> getInstructors();

}
