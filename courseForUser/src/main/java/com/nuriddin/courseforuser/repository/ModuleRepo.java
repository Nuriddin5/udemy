package com.nuriddin.courseforuser.repository;


import com.nuriddin.courseforuser.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepo extends JpaRepository<Module, Long> {
}
