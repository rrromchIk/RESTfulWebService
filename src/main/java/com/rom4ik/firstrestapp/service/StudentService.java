package com.rom4ik.firstrestapp.service;

import com.rom4ik.firstrestapp.exception.StudentNotFoundException;
import com.rom4ik.firstrestapp.model.Student;
import com.rom4ik.firstrestapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author rom4ik
 */
@Service
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Student findById(int id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        return studentOptional.orElseThrow(StudentNotFoundException::new);
    }

    public void delete(int id) {
        studentRepository.deleteById(id);
    }

    public void create(Student student) {
        studentRepository.save(student);
    }

    public void update(Student student, int id) {
        student.setId(id);
        studentRepository.save(student);
    }
}
