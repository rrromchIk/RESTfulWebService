package com.rom4ik.firstrestapp.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rom4ik
 */
@Data
@NoArgsConstructor
public class Student {
    private int id;

    @NotEmpty(message = "Group should not be empty!")
    @NotNull(message = "Group should not be null!")
    private String group;

    @NotEmpty(message = "First name should not be empty!")
    @NotNull(message = "First name should not be null!")
    private String firstName;

    @NotEmpty(message = "Last name should not be empty!")
    @NotNull(message = "Last name should not be null!")
    private String lastName;

    @NotEmpty(message = "Group should not be empty!")
    @NotNull(message = "Group should not be null!")
    private String birthday;

    @NotEmpty(message = "Gender should not be empty!")
    @NotNull(message = "Gender should not be null!")
    private String gender;
}
