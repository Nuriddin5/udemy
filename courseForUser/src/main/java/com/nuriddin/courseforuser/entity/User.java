package com.nuriddin.my_teaching_project_like_udemy.entity;


// t.me/superJavaDeveloper 15.04.2022;

import com.nuriddin.my_teaching_project_like_udemy.entity.template.AbsUUIDEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
 
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "users")

public class User extends AbsUUIDEntity {


    @Column(nullable = false)
    String fullName;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String password;


    String headLine;

    String biography;

    Integer avgRating;

    Integer numberOfReviews;

    Integer numberOfStudents;


    String phoneNumber;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    @ToString.Exclude
    List<CourseRate> courseRates;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    @ToString.Exclude
    List<LessonStatusForUser> lessonStatusForUsers;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
