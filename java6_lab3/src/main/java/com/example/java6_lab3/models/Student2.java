package com.example.java6_lab3.models;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student2 {
    @NotBlank(message = "{error.email}")
    @Email(message = "{error.validEmail}")
    String email;
    @NotBlank(message = "{error.name}")
    String fullName;
    @NotNull(message = "{error.mark}")
    @PositiveOrZero(message = "{error.markPositiveOrZero}")
    @Max(value = 10, message = "{error.markMax10}")
    Double marks;
    @NotNull(message = "{error.gender}")
    Boolean gender;
    @NotBlank(message = "{error.nation}")
    String country;
}
