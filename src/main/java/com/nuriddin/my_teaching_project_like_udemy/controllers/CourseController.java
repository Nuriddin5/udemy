package com.nuriddin.my_teaching_project_like_udemy.controllers;


// t.me/superJavaDeveloper 08.06.2022;

import com.nuriddin.my_teaching_project_like_udemy.entity.Lesson;
import com.nuriddin.my_teaching_project_like_udemy.entity.Module;
import com.nuriddin.my_teaching_project_like_udemy.repository.CategoryRepo;
import com.nuriddin.my_teaching_project_like_udemy.repository.CourseRepo;
import com.nuriddin.my_teaching_project_like_udemy.repository.LessonRepo;
import com.nuriddin.my_teaching_project_like_udemy.repository.ModuleRepo;
import com.nuriddin.my_teaching_project_like_udemy.service.UtilFunctions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.nuriddin.my_teaching_project_like_udemy.service.UtilFunctions.isLogged;

@Controller
@RequiredArgsConstructor
public class CourseController {
    private final CourseRepo courseRepo;
    private final CategoryRepo categoryRepo;
    private final ModuleRepo moduleRepo;
    private final LessonRepo lessonRepo;
    private final UtilFunctions utilFunctions;

//    @GetMapping({"/courses","/"})
//    public String getCourses2(Model model, @RequestParam(value = "page",required = false) Integer page) {
////        model.addAttribute("categoryName", "All");
//
//        model.addAttribute("courses", courseRepo.findAll());
//        model.addAttribute("categories", categoryRepo.findAll());
//        return "courses";
//    }

    @GetMapping({"/courses", "/"})
    public String getCoursesForSearch(Model model, @RequestParam(value = "query", required = false) String query) {
//        model.addAttribute("categoryName", "All");

        model.addAttribute("isLogged", isLogged());
        model.addAttribute("courses", courseRepo.findCourseForSearch(query));
        model.addAttribute("categories", categoryRepo.findAll());
        return "courses";
    }


    @GetMapping("/courses/{categoryPathName}")
    public String getCourses(Model model, @PathVariable String categoryPathName) {
        if (categoryPathName.equals("analytics.js")) {
            model.addAttribute("isLogged", isLogged());
            model.addAttribute("courses", courseRepo.findAll());
            model.addAttribute("categories", categoryRepo.findAll());
            return "courses";
        }

        model.addAttribute("isLogged", isLogged());
        model.addAttribute("courses", courseRepo.findAllByCategoryId(categoryRepo.findByPathName(categoryPathName).getId()));
        model.addAttribute("categories", categoryRepo.findAll());


        return "courses";
    }

    @GetMapping("/p/{coursePathName}")
    public String getNECourses(@PathVariable String coursePathName, Model model) {
        Module firstModule = moduleRepo.findFirstByCoursePathName(coursePathName);
        List<Lesson> lessonsByFirstModule = null;
        if (firstModule != null) {
            lessonsByFirstModule = lessonRepo.findAllByModuleId(firstModule.getId());
        }


        model.addAttribute("isLogged", isLogged());
        if (firstModule != null) {
            model.addAttribute("firstModuleName", firstModule.getName());
        }
        model.addAttribute("lessonsByFirstModule",
                lessonsByFirstModule);
        model.addAttribute("lessonsFromSecondModule", moduleRepo.findFromSecond(coursePathName));
        model.addAttribute("course", courseRepo.findByPathName(coursePathName));
        return "notEnrolledCourse";
    }

    @GetMapping("/courses/{coursePathName}/lectures/{lectureId}")
    public String getLecturesOfCourse(@PathVariable String coursePathName, Model model, @PathVariable Long lectureId) {
//
//

        model.addAttribute("isLogged", isLogged());
        model.addAttribute("lecture", lessonRepo.findById(lectureId).get());
        model.addAttribute("course", courseRepo.findByPathName(coursePathName));
        model.addAttribute("modules", moduleRepo.findAllByCoursePathName(coursePathName));

        return "courseView";
    }
}
