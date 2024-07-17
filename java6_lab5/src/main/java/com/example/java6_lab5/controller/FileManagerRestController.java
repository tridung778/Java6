package com.example.java6_lab5.controller;

import com.example.java6_lab5.service.FileManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest/files")
public class FileManagerRestController {

    @Autowired
    FileManagerService fileManagerService;

    @GetMapping("/{folder}/{fileName}")
    public byte[] getFile(@PathVariable("folder") String folder, @PathVariable("fileName") String fileName) {
        return fileManagerService.read(folder, fileName);
    }

    @PostMapping("/{folder}")
    public List<String> saveFile(@PathVariable String folder, @RequestParam("files") MultipartFile[] files) {
        return fileManagerService.save(folder, files);
    }

    @DeleteMapping("/{folder}/{fileName}")
    public void deleteFile(@PathVariable("folder") String folder, @PathVariable("fileName") String fileName) {
        fileManagerService.delete(folder, fileName);
    }

    @GetMapping("/{folder}")
    public List<String> listFiles(@PathVariable("folder") String folder) {
        return fileManagerService.list(folder);
    }
}

