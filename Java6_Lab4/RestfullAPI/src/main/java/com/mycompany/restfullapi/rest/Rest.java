package com.mycompany.restfullapi.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.HttpURLConnection;
import java.net.URL;

public class Rest {
    private static ObjectMapper mapper = new ObjectMapper();

    public static JsonNode post(String path, Object data) {
        return request("POST", path, data);
    }

    public static JsonNode get(String path) {
        return request("GET", path, null);
    }

    public static JsonNode put(String path, Object data) {
        return request("PUT", path, data);
    }

    public static JsonNode delete(String path) {
        return request("DELETE", path, null);
    }


    private static JsonNode request(String method, String path, Object data) {
        try {
            String uri = "https://poly-java6-f608c-default-rtdb.asia-southeast1.firebasedatabase.app/" + path + ".json";
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestMethod(method);

            if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT")) {
                connection.setDoOutput(true);
                mapper.writeValue(connection.getOutputStream(), data);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return mapper.readTree(connection.getInputStream());
            }
            connection.disconnect();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
