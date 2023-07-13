package com.rom4ik.firstrestapp.controller;

import com.rom4ik.firstrestapp.dao.StudentDAO;
import com.rom4ik.firstrestapp.model.Student;
import com.rom4ik.firstrestapp.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author rom4ik
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class StudentsController {
    private final StudentDAO studentDAO;

    @Autowired
    public StudentsController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping("/students")
    public List<Student> getAll() {
        return studentDAO.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getById(@PathVariable int id) {
        return studentDAO.findById(id);
    }

    @PostMapping("/students")
    public ResponseEntity<HttpStatus> createStudent(@RequestBody Student student) {
        System.out.println("students:post");
        studentDAO.create(student);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable int id) {
        studentDAO.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/students/{id}")
    public ResponseEntity<HttpStatus> updateStudent(@RequestBody Student student,
                                                    @PathVariable int id) {
        System.out.println(student);
        studentDAO.update(student, id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse(
                "Student with such id not found"
        );
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<StudentErrorResponse> handleException(StudentCreationException exc) {
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse(
                "Error while creating student"
        );
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler
    private ResponseEntity<StudentErrorResponse> handleException(StudentUpdateException exc) {
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse(
                "Error while updating student"
        );
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<StudentErrorResponse> handleException(StudentDeleteException exc) {
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse(
                "Error while deleting student"
        );
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
