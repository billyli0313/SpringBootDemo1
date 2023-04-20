package com.example.springbootdemo1.repository;

import com.example.springbootdemo1.entity.Student;
import com.example.springbootdemo1.entity.Teacher;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TeacherRepository {
    static HashMap<String, Teacher> teacherStorage = new HashMap<>();

    public Teacher getTeacher(String id){
        return teacherStorage.get(id);
    }

    public boolean saveTeacher(Teacher teacher){
        String id = teacher.getId();
        if(!teacherStorage.containsKey(id)) {
            teacherStorage.put(id, teacher);
            return true;
        }
        return false;
    }

    public void addStudent(Teacher teacher, Student student){
        teacher.addStudent(student);
    }

    public void removeStudent(Teacher teacher,Student student){
        teacher.removeStudent(student);
    }

    public List<Student> listAllStudents(Teacher teacher){
        return teacher.getStudents().stream().collect(Collectors.toList());
    }








}
