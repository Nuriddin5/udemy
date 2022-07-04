package com.nuriddin.my_teaching_project_like_udemy;

import com.nuriddin.my_teaching_project_like_udemy.storage.StorageProperties;
import com.nuriddin.my_teaching_project_like_udemy.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import static com.nuriddin.my_teaching_project_like_udemy.service.UtilFunctions.isLogged;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class MyTeachingProjectLikeUdemyApplication {

    public static void main(String[] args) {
        System.out.println(isLogged());
        SpringApplication.run(MyTeachingProjectLikeUdemyApplication.class, args);
    }

//    @Bean
//    CommandLineRunner init(StorageService storageService) {
//        return (args) -> {
//            storageService.deleteAll();
//            storageService.init();
//        };
//    }
}
