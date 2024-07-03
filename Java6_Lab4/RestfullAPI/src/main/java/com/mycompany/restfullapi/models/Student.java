package com.mycompany.restfullapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Student {
    private String fullName;
    private String email;
    private Double marks;
    private Boolean gender;
    private String country;

    public Student() {
    }

    public Student(String fullName, String email, Double marks, String country, Boolean gender) {
        this.fullName = fullName;
        this.email = email;
        this.marks = marks;
        this.country = country;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    public Object[] getArray() {
        return new Object[]{
                getFullName(),
                getEmail(),
                getMarks(),
                getGender(),
                getCountry()
        };
    }
}
