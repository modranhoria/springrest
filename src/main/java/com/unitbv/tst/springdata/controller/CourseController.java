package com.unitbv.tst.springdata.controller;

import com.unitbv.tst.springdata.entity.Course;
import com.unitbv.tst.springdata.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
   private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable("id") Integer id) {
        return courseService.getCourse(id);
    }

    @PostMapping("/courses")
    public Course saveCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable("id") Integer id) {
        courseService.deleteCourse(id);
    }
}
