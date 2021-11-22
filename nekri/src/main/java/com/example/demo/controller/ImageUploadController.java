package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api")
public class ImageUploadController {
    private static String imageDirectory = System.getProperty("user.dir") + "/../colloc-app/src/images/";
    // private static String imageDirectory = System.getProperty("user.dir") +
    // "\\..\\..\\colloc-app\\src\\images\\";

    @RequestMapping(value = "/upload/image", produces = { MediaType.IMAGE_PNG_VALUE, "application/json" })
    public ResponseEntity<Map<String, Boolean>> uploadImage(@RequestParam("imageFile") MultipartFile file,
            @RequestParam("imageName") String name) {

        makeDirectoryIfNotExist(imageDirectory);
        Path fileNamePath = Paths.get(imageDirectory, name);
        Map<String, Boolean> response = new HashMap<>();

        try {
            Files.write(fileNamePath, file.getBytes());
            response.put("uploaded", Boolean.TRUE);
            return ResponseEntity.ok(response);
        } catch (IOException ex) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> image error :  " + ex);
            response.put("uploaded", Boolean.FALSE);
            return ResponseEntity.ok(response);
        }
    }

    private void makeDirectoryIfNotExist(String imageDirectory) {
        File directory = new File(imageDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }
}
