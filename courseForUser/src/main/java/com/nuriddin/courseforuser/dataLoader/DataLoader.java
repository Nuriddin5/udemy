package com.nuriddin.courseforuser.dataLoader;

import com.nuriddin.courseforuser.entity.Course;
import com.nuriddin.courseforuser.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;

public record DataLoader(@Value("${spring.sql.init.mode}")
                         String initMode,
                         CourseRepo courseRepo
                         ) implements CommandLineRunner {




    @Override
    public void run(String... args) throws Exception {

        if (initMode.equals("always")) {


            ArrayList<Course> courses = new ArrayList<>();

        }
    }
}
