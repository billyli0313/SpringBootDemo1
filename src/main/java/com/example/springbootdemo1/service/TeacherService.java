package com.example.springbootdemo1.service;

import com.example.springbootdemo1.entity.Student;
import com.example.springbootdemo1.entity.Teacher;
import com.example.springbootdemo1.repository.TeacherRepository;

import java.util.List;

public class TeacherService {

    private TeacherRepository teacherRepository = new TeacherRepository();

    public Teacher getTeacherById(String id){
        return teacherRepository.getTeacher(id);
    }

    public String saveTeacher(Teacher teacher){
        if(teacherRepository.saveTeacher(teacher)){
            return "Successfully created!";
        }
        return teacher.getId() + " already exists!";
    }

    public void addStudent(Teacher teacher, Student student){
        teacherRepository.addStudent(teacher,student);
    }

    public List<Student> listAllStudents(Teacher teacher){
        return teacherRepository.listAllStudents(teacher);
    }

}
