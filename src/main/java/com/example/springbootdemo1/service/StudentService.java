package com.example.springbootdemo1.service;

import com.example.springbootdemo1.entity.Student;
import com.example.springbootdemo1.repository.StudentRepository;

import java.util.List;

public class StudentService {

    private StudentRepository studentRepository = new StudentRepository();

    public List<Student> listAllStudents(){
//        if(studentRepository.listStudents().isEmpty()){
//            return "No student exists!";
//        }
        return studentRepository.listStudents();
    }

    public String getStudentById(String id){
        if(studentRepository.loadStudent(id)==null){
            return "Student id: " + id + " does not exist!";
        }
        return studentRepository.loadStudent(id).toString();
    }
    public Student getById(String id){
        return studentRepository.loadStudent(id);
    }
    public boolean idExist(String id){
        if(studentRepository.loadStudent(id)==null){
            return false;
        }
        return true;
    }
    public String createStudent(Student student){
        if(studentRepository.saveStudent(student)){
            return "Successfully created!";
        }
        return student.getId() + " already exists!";
    }
    public String updateStudent(Student student){
        if(studentRepository.updateStudent(student)){
            return "Successfully updated!";
        }
        return "Update failed!";
    }
    public String deleteStudent(Student student){
        if(studentRepository.deleteStudent(student)){
            return "Successfully deleted!";
        }
        return "Failed to delete!";
    }
}
