package com.rom4ik.firstrestapp.dao;

import com.rom4ik.firstrestapp.model.Student;
import com.rom4ik.firstrestapp.util.StudentCreationException;
import com.rom4ik.firstrestapp.util.StudentDeleteException;
import com.rom4ik.firstrestapp.util.StudentNotFoundException;
import com.rom4ik.firstrestapp.util.StudentUpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author rom4ik
 */
@Component
public class StudentDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> findAll() {
        return jdbcTemplate.query("SELECT * FROM student", new BeanPropertyRowMapper<>(Student.class))
                .stream().toList();
    }

    public Student findById(int id) {
        return jdbcTemplate.query("SELECT * FROM student WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Student.class))
                .stream().findAny().orElseThrow(StudentNotFoundException::new);
    }

    public void create(Student student) {
        int result = jdbcTemplate.update("INSERT INTO student(`group`, firstName, lastName, birthday, gender) VALUES(?, ?, ?, ?, ?)",
                student.getGroup(), student.getFirstName(), student.getLastName(), student.getBirthday(), student.getGender());

        if(result <= 0) {
            throw new StudentCreationException();
        }
    }

    public void update(Student student, int id) {
        int result = jdbcTemplate.update("UPDATE student set `group` = ?, firstName = ?, lastName = ?, birthday = ?," +
                        " gender = ? WHERE id = ?",
                student.getGroup(),
                student.getFirstName(),
                student.getLastName(),
                student.getBirthday(),
                student.getGender(),
                id);

        if(result <= 0) {
            throw new StudentUpdateException();
        }
    }

    public void delete(int id) {
        int result = jdbcTemplate.update("DELETE FROM student WHERE id = ?", id);

        if(result <= 0) {
            throw new StudentDeleteException();
        }
    }
}
