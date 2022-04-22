package com.nuriddin.courseforuser.entity;


// t.me/superJavaDeveloper 15.04.2022;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class UsersCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    UUID instructorId;

    @Column(nullable = false)
    Long courseId;


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        Course courses = (Course) o;
//        return getId() != null && Objects.equals(getId(), courses.getId());
//    }
//
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }

}
