package com.meklit.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;




    @RequestMapping("/")
    public String studentList(Model model){


        model.addAttribute("students", studentRepository.findAll());
        return "studentlist";

    }

    @GetMapping("/add")
    public String courseForm(Model model){
        model.addAttribute("course", new Course());
        return "courseform";
    }
    @PostMapping("/process")
    public String processForm(@Valid Course course, BindingResult result)
    {
        if(result.hasErrors()){
            return "courseform";
        }
        courseRepository.save(course);
        return "redirect:/";
    }


    @GetMapping("/addstudent")
    public String studentForm(Model model){
        model.addAttribute("student", new Course());
        return "studentform";
    }
    @PostMapping("/studentprocess")
    public String processForm(@Valid Student student, BindingResult result)
    {
        if(result.hasErrors()){
            return "studentform";
        }
        studentRepository.save(student);
        return "redirect:/";
    }

    /*
    @RequestMapping("/")
    public String listCourses(Model model){
        model.addAttribute("courses", courseRepository.findAll());
        return "list";
    }

    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("course", courseRepository.findOne(id));
        return "show";
    }
    @RequestMapping("update/{id}")
    public String updateCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("course", courseRepository.findOne(id));
        return "courseform";
    }
    @RequestMapping("/delete/{id}")
    public String delCourse(@PathVariable("id") long id){
        courseRepository.delete(id);
        return "redirect:/";
    }*/
}
