package com.example.springbootdemo1.controller;

import com.example.springbootdemo1.entity.Teacher;
import com.example.springbootdemo1.service.TeacherService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {
    private TeacherService service = new TeacherService();
    @PostMapping(value = "/create/teacher")
    public String createTeacher(@RequestBody Teacher teacher){

        return service.saveTeacher(teacher);
    }
    @GetMapping(value = "/teacher")
    @ResponseBody
    public Teacher getTeacher(@RequestParam(value = "id")String id){
        return service.getTeacherById(id);
    }


}
