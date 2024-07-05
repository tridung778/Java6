package com.example.RestTemplate.DAO;


import com.example.RestTemplate.bean.StudentMap;
import com.example.RestTemplate.model.Student;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class StudentDAO {

    RestTemplate rest = new RestTemplate();

    String url = "https://poly-java6-f608c-default-rtdb.asia-southeast1.firebasedatabase.app/students.json";

    private String getUrl(String key) {
        return url.replace(".json", "/" + key + ".json");
    }

    public StudentMap findALl() {
        return rest.getForObject(url, StudentMap.class);
    }

    public Student findByKey(String key){
        return rest.getForObject(getUrl(key),Student.class);
    }

    public String create(Student student){
        HttpEntity<Student> entity = new HttpEntity<>(student);
        JsonNode response = rest.postForObject(url, entity, JsonNode.class);
        return response.get("name").asText();
    }

    public Student update(Student student, String key){
        HttpEntity<Student> entity = new HttpEntity<>(student);
        rest.put(getUrl(key), entity);
        return student;
    }

    public void delete(String key){
        rest.delete(getUrl(key));
    }

}


