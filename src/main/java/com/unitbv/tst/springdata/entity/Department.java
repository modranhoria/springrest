package com.unitbv.tst.springdata.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
@SequenceGenerator(name = "dept_seq", initialValue = 2)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq")
    @Column(name = "dept_id")
    private Integer id;

    @Column(name = "dept_name")
    private String name;

    @OneToMany(mappedBy = "department")
    @JsonManagedReference
    private List<Course> courseList = new ArrayList<>();

    public Department() {
    }

    public Department(Integer id, String name, List<Course> courseList) {
        this.id = id;
        this.name = name;
        this.courseList = courseList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
