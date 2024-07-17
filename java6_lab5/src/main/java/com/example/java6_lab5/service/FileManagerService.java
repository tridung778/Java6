package com.example.java6_lab5.service;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileManagerService {

    @Autowired
    ServletContext context;

    private Path getPath(String folder, String fileName) {
        File dir = Paths.get(context.getRealPath("/files/"), folder).toFile();
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return Paths.get(dir.getAbsolutePath(), fileName);
    }

    public byte[] read(String folder, String fileName) {
        Path path = getPath(folder, fileName);
        try {
            return Files.readAllBytes(path);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public List<String> save(String folder, MultipartFile[] files) {
        List<String> filesName = new ArrayList<>();
        for (MultipartFile file : files) {
            String name = System.currentTimeMillis() + file.getOriginalFilename();
            String fileName = Integer.toHexString(name.hashCode()) + name.substring(name.lastIndexOf("."));
            Path path = this.getPath(folder, fileName);
            try {
                file.transferTo(path);
                filesName.add(fileName);
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
        return filesName;
    }

    public void delete(String folder, String fileName) {
        Path path = getPath(folder, fileName);
        path.toFile().delete();
    }

    public List<String> list(String folder) {
        List<String> filesName = new ArrayList<>();
        File dir = Paths.get(context.getRealPath("/files/"), folder).toFile();
        if (!dir.exists()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                filesName.add(file.getName());
            }
        }
        return filesName;
    }
}
