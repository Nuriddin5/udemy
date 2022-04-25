package com.nuriddin.courseforuser.dto;

import com.nuriddin.courseforuser.entity.enums.CourseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDto {

    String name;

    Double price;

    List<UUID> instructors;

    String headline;

    Long photoId;

    // TODO: 21.04.2022 write query
    float avgRating;

    CourseStatus status;

}
