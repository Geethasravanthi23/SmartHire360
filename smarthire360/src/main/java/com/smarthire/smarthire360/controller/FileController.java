package com.smarthire.smarthire360.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
@CrossOrigin(origins = "http://localhost:5173")
public class FileController {

    private final String uploadDir = "C:/uploads/";

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(
            @RequestParam("file") MultipartFile file)
            throws IOException {

        String fileName =
                StringUtils.cleanPath(
                        file.getOriginalFilename());

        File destination =
                new File(uploadDir + fileName);

        file.transferTo(destination);

        return ResponseEntity.ok(
                "File Uploaded Successfully");
    }
}