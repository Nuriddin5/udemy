package com.nuriddin.my_teaching_project_like_udemy.entity;


// t.me/superJavaDeveloper 15.04.2022;

import com.nuriddin.my_teaching_project_like_udemy.entity.enums.CourseStatus;
import com.nuriddin.my_teaching_project_like_udemy.entity.template.AbsLongEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Course extends AbsLongEntity {
    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    Double price;

    @ManyToMany
    @ToString.Exclude
    List<User> instructors;

    @Column(nullable = false)
    String headline;

    @OneToOne
    @JoinColumn(name = "preview_video_id")
    Attachment previewVideo;

    @Column(nullable = false)
    String description;

    @Column(nullable = false)
    String language;


    Float avgRating;

    @Column(nullable = false)
    String learningSkills;

    @Column(nullable = false)
    String requirements;

    @ManyToMany
    @ToString.Exclude
    List<Category> categories;

    @Enumerated(EnumType.STRING)
    CourseStatus status;

    @OneToMany(mappedBy = "course", orphanRemoval = true)
    @ToString.Exclude
    List<Module> modules;

    @OneToMany(mappedBy = "course", orphanRemoval = true)
    @ToString.Exclude
    List<CourseRate> courseRates;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Course courses = (Course) o;
        return getId() != null && Objects.equals(getId(), courses.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
