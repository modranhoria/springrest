package com.unitbv.tst.springdata.controller;

import com.unitbv.tst.springdata.entity.Student;
import com.unitbv.tst.springdata.service.StudentService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudents(@PathVariable("id") Integer id) {
        return studentService.getStudent(id);
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable("id") Integer id,
                                 @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @PatchMapping("/students/{id}")
    public Student updatePatchStudent(@PathVariable("id") Integer id,
                                 @RequestBody Student student) {
        return studentService.updatePatchStudent(id, student);
    }

    @DeleteMapping("/students/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
    }
}
