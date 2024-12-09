package com.unitbv.tst.springdata.service;

import com.unitbv.tst.springdata.entity.Student;
import com.unitbv.tst.springdata.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(Integer id) {
        return studentRepository.findById(id).get();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Integer id, Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    public Student updatePatchStudent(Integer id, Student student) {
        Student updatedStudent = studentRepository.findById(id).get();
        student.setId(id);
        if(student.getName() != null) {
            updatedStudent.setName(student.getName());
        }
        if(student.isFullTime() != null) {
            updatedStudent.setFullTime(student.isFullTime());
        }
        if(student.getAge() != null) {
            updatedStudent.setAge(student.getAge());
        }
        return studentRepository.save(updatedStudent);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
