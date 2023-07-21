package com.rom4ik.firstrestapp.repository;

import com.rom4ik.firstrestapp.model.Student;
import com.rom4ik.firstrestapp.exception.StudentCRUDException;
import com.rom4ik.firstrestapp.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rom4ik
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    /*private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentRepository(JdbcTemplate jdbcTemplate) {
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
            throw new StudentCRUDException("Error while creating student");
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
            throw new StudentCRUDException("Error while updating student");
        }
    }

    public void delete(int id) {
        int result = jdbcTemplate.update("DELETE FROM student WHERE id = ?", id);

        if(result <= 0) {
            throw new StudentCRUDException("Error while deleting student");
        }
    }*/
}
