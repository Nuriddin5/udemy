package com.nuriddin.my_teaching_project_like_udemy.repository;


import com.nuriddin.my_teaching_project_like_udemy.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface ModuleRepo extends JpaRepository<Module, Long> {

    List<Module> findAllByCoursePathName(String course_pathName);

    Module findFirstByCoursePathName(String course_pathName);

    @Query(nativeQuery = true,
            value = "select * from module m " +
                    "join course c on m.course_id = c.id " +
                    "where c.path_name = :course_pathName offset 1"

    )
    List<Module> findFromSecond(String course_pathName);

}
