package com.nuriddin.my_teaching_project_like_udemy.entity;

import com.nuriddin.my_teaching_project_like_udemy.entity.template.AbsLongEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

import static com.nuriddin.my_teaching_project_like_udemy.service.UtilFunctions.getUniquePathName;

// t.me/superJavaDeveloper 15.04.2022;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
 
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity


public class Category extends AbsLongEntity {
    @Column(nullable = false)
    String name;

    @Column(nullable = false,unique = true)
    String pathName;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "parent_id")
//    @ToString.Exclude
//    Category parent;


    public Category(String name) {
        this.name = name;
        this.pathName = getUniquePathName(name);
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Category category = (Category) o;
        return getId() != null && Objects.equals(getId(), category.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
