package com.example.java6_lab3.models;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student2 {
    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email phải đúng định dạng")
    String email;
    @NotBlank(message = "Họ tên không được để trống")
    String fullName;
    @NotNull(message = "Điểm không được để trống")
    @PositiveOrZero(message = "Điểm phải lớn hơn 0")
    @Max(value = 10, message = "Điểm phải bé hơn hoặc bằng 10")
    Double marks;
    @NotNull(message = "Giới tính không được để trống")
    Boolean gender;
    @NotBlank(message = "Quốc tịch không được để trống")
    String country;
}
