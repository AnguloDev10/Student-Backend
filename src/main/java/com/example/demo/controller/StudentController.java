package com.example.demo.controller;

import com.example.demo.repository.SkillRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    @Autowired
    private final SkillRepository skillRepository;

    @Autowired
    public StudentController(StudentService studentService, SkillRepository skillRepository) {
        this.studentService = studentService;
        this.skillRepository = skillRepository;
    }

    @RequestMapping
   public String StudentAdd(@RequestParam String name, @RequestParam String email, @RequestParam Integer age, Model model) {
        return "hi";
    }

   // @GetMapping
   // public List<Student> getStudent(){return studentService.getStudent();
    //}

}
