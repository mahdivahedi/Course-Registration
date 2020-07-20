package ir.example.demo.controller;


import ir.example.demo.data.CourseRepository;
import ir.example.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository repository;


    @GetMapping("/{name}/all")
    public List<Course> findAllStudentCourses(@PathVariable("name") String name){

        return (List<Course>) repository.findAll();

    }

}
