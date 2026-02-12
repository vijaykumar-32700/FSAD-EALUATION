package com.klu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.klu.model.Student;
import com.klu.service.StudentService;

@Service
public class StudentServiceimpl implements StudentService {

    private List<Student> studentList = new ArrayList<>();

    @Override
    public String getWelcomeMessage() {
        return "Welcome to Student MVC CRUD Application";
    }

    // CREATE
    @Override
    public Student createStudent(Student student) {
        studentList.add(student);
        return student;
    }

    // READ - by id
    @Override
    public Student getStudentById(int id) {
        for (Student s : studentList) {
            if (s.getid() == id) {
                return s;
            }
        }
        return null;
    }

    // READ - all
    @Override
    public List<Student> getAllStudents() {
        return studentList;
    }

    // UPDATE
    @Override
    public Student updateStudent(int id, Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getid() == id) {
                student.setId(id);
                studentList.set(i, student);
                return student;
            }
        }
        return null;
    }

    // DELETE
    @Override
    public String deleteStudent(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getid() == id) {
                studentList.remove(i);
                return "Student record deleted successfully";
            }
        }
        return "No student record found";
    }

    // SEARCH
    @Override
    public List<Student> searchStudent(String name, String course) {
        List<Student> result = new ArrayList<>();

        for (Student s : studentList) {
            if (s.getName().equalsIgnoreCase(name)
                    && s.getcourse().equalsIgnoreCase(course)) {
                result.add(s);
            }
        }
        return result;
    }
}