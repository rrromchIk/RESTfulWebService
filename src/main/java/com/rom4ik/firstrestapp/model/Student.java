package com.rom4ik.firstrestapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rom4ik
 */
@Data
@NoArgsConstructor
@Entity
@Table
public class Student {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "`group`")
    private String group;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String birthday;
    @Column
    private String gender;
}
