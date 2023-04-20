package com.example.springbootdemo1.repository;

import com.example.springbootdemo1.entity.Student;

import java.util.*;
import java.util.stream.Collectors;


public class StudentRepository {

    static Map<String, Student> studentStorage = new HashMap<>();
    public List<Student> listStudents(){
        return  studentStorage.values().stream().collect(Collectors.toList());
    }
    public Student loadStudent (String studentId){
        return studentStorage.getOrDefault(studentId,null);
    }
    public boolean saveStudent(Student student){
        String id = student.getId();
        if(!studentStorage.containsKey(id)){
            studentStorage.put(id,student);
            return true;
        }
        return false;
    }

    public boolean updateStudent(Student student){
        String id = student.getId();
        if(studentStorage.containsKey(id)){
            studentStorage.put(id,student);
            return true;
        }
        return false;
    }
    public boolean deleteStudent(Student student){
        String id = student.getId();
        if (studentStorage.containsKey(id)){
            studentStorage.remove(id);
            return true;
        }
        return false;
    }
}
