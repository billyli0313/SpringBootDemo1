package com.example.springbootdemo1.controller;

import com.example.springbootdemo1.entity.Student;
import com.example.springbootdemo1.entity.Teacher;
import com.example.springbootdemo1.service.StudentService;
import com.example.springbootdemo1.service.TeacherService;
import org.springframework.web.bind.annotation.*;


@RestController
public class SignUpController {
    private TeacherService teacherService = new TeacherService();
    private StudentService studentService = new StudentService();
    @PostMapping(value = "/signup")
    public String signUpTeacherAndStudent(@RequestParam(value = "studentId")String studentId,
                              @RequestParam(value = "teacherId")String teacherId){
        Student student = studentService.getById(studentId);
        Teacher teacher = teacherService.getTeacherById(teacherId);

        if(teacher != null && student != null){
            if(student.getTeacherId() != null){
                return "The student has the teacher: " + student.getTeacherId() + " , cannot sign up again!";
            }
            student.setTeacherId(teacherId);
            studentService.updateStudent(student);
            teacherService.addStudent(teacher,student);
            teacherService.saveTeacher(teacher);
            return "Successfully connect!";
        }else if(teacher == null){
            return "The teacher does not exist！";
        }else {
            return "The student does not exist！";
        }
    }
    @PutMapping(value = "/update/signup")
    public String updateSignup(@RequestParam(value = "studentId")String studentId,
                             @RequestParam(value = "teacherId")String teacherId) {
        Student student = studentService.getById(studentId);
        Teacher teacher = teacherService.getTeacherById(teacherId);
        if(teacher != null && student != null){
//            cleanup previous connection
            if(student.getTeacherId() != null){
                Teacher previousTeacher = teacherService.getTeacherById(student.getTeacherId());
                previousTeacher.removeStudent(student);
            }
//            build up new connection
            student.setTeacherId(teacherId);
            studentService.updateStudent(student);
            teacherService.addStudent(teacher,student);
            teacherService.saveTeacher(teacher);
            return "Update connection successfully!";
        }else if(teacher == null){
            return "The teacher does not exist！";
        }else {
            return "The student does not exist！";
        }
    }
    @DeleteMapping(value = "delete/signup")
    public String deleteSignup(@RequestParam(value = "studentId")String studentId){
        Student student = studentService.getById(studentId);
        if(student != null) {
            if (student.getTeacherId() != null){
                Teacher teacher = teacherService.getTeacherById(student.getTeacherId());
                teacher.removeStudent(student);
                student.setTeacherId(null);
                return "Delete connection successfully!";
            }else{
                return "The student has no teacher yet!";
            }
        }else{
            return "The student does not exist！";
        }
    }
}
