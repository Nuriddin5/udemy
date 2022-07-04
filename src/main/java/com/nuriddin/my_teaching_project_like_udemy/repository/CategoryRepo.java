package com.nuriddin.my_teaching_project_like_udemy.repository;


import com.nuriddin.my_teaching_project_like_udemy.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category findByName(String name);

    Category findByPathName(String pathName);

}
