package com.example.springbootdemo1.entity;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
    private String id;
    private String name;
    private String phone;

    public Set<Student> students = new HashSet<>();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
    public Set<Student> getStudents (){
        return students;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    public void addStudent(Student student){
        this.students.add(student);
    }
    public void removeStudent(Student student){
        this.students.remove(student);
    }
}
