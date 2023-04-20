package com.example.springbootdemo1.entity;

public class Student {
    private String id;
    private String name;
    private  int age;
    private String address;

    private String teacherId;

    public Student(String id, String name){
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String toString(){
        return "Student id: " + this.id + "; " +
                "Student name: " + this.name + "; " +
                "Student age: " + this.age + "; " +
                "Student address: " + this.address + "; " +
                "Teacher ID: " + this.teacherId;
    }
}
