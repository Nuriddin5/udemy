package com.nuriddin.courseforuser.repository;


import com.nuriddin.courseforuser.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
