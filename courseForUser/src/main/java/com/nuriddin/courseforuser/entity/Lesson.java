package com.nuriddin.courseforuser.entity;

import com.nuriddin.courseforuser.entity.template.AbsLongEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

// t.me/superJavaDeveloper 15.04.2022;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
 
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity


public class Lesson extends AbsLongEntity {

    @Column(nullable = false)
    String name;


    @Column(name = "video_id")
    Long videoId;

    @OneToMany(mappedBy = "lesson", orphanRemoval = true)
    @ToString.Exclude
    List<Resource> resources;

    @OneToMany(mappedBy = "lesson", orphanRemoval = true)
    @ToString.Exclude
    List<LessonStatusForUser> lessonStatusForUsers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Lesson that = (Lesson) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
