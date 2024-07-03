package com.mycompany.restfullapi.DAO;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.restfullapi.models.Student;
import com.mycompany.restfullapi.models.StudentMap;
import com.mycompany.restfullapi.rest.Rest;

public class StudentDAO {

    ObjectMapper mapper = new ObjectMapper();

    public StudentMap findAll() {
        JsonNode response = Rest.get("students");
        return mapper.convertValue(response, StudentMap.class);
    }

    public Student findByKey(String key) {
        JsonNode response = Rest.get("students/" + key);
        return mapper.convertValue(response, Student.class);
    }

    public String create(Student student) {
        JsonNode response = Rest.post("students", student);
        return response.get("name").asText();
    }

    public Student update(String key, Student student) {
        JsonNode response = Rest.put("students/" + key, student);
        return mapper.convertValue(response, Student.class);
    }

    public void delete(String key) {
        Rest.delete("students/" + key);
    }

}
