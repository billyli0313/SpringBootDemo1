package com.example.springbootdemo1.controller;

import com.example.springbootdemo1.entity.Student;
import com.example.springbootdemo1.repository.StudentRepository;
import com.example.springbootdemo1.service.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class StudentController  {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String start(){
        return "Welcome to Student Profile System!";
    }
    private StudentService service = new StudentService();

    @GetMapping(value = "/students")
    public List<Student> listAllStudents(){
        return  service.listAllStudents();
    }

    @GetMapping(value = "/student/{id}")
    public String getStudentById(@PathVariable(value = "id")String id){
        return service.getStudentById(id).toString();
    }

    @PostMapping(value = "/create/student")
    public String createStudent(@RequestParam(value = "id")String id,@RequestParam(value = "name")String name,
                              @RequestParam(value = "age")int age,@RequestParam(value = "address")String address){
        Student student = new Student(id,name);
        student.setAge(age);
        student.setAddress(address);
        return service.createStudent(student);
    }

    @PutMapping(value = "/update/student")
    public String updateStudent(@RequestParam(value = "id")String id,@RequestParam(value = "name")String name,
                              @RequestParam(value = "age")int age,@RequestParam(value = "address")String address){
        if(!service.idExist(id)){
            return "No such student id: " + id + " found";
        }
        Student student = service.getById(id);
        student.setName(name);
        student.setAge(age);
        student.setAddress(address);
        return service.updateStudent(student);
    }

    @DeleteMapping(value = "/delete/student")
    public String deleteStudent(@RequestParam(value = "id")String id){
        if(!service.idExist(id)){
            return "No such student id: " + id + " found";
        }
        Student student = service.getById(id);
        return service.deleteStudent(student);
    }
    @PostMapping(value = "create/new/student")
    public String createNewStudent(@RequestBody Student student){
        return service.createStudent(student);
    }
    @GetMapping(value = "student/new/{id}")
    @ResponseBody
    public String getNewStudent(@PathVariable(value = "id")String id){
        return service.getStudentById(id).toString();
    }
}
