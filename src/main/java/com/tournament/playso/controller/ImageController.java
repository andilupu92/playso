package com.tournament.playso.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/api")
public class ImageController {

    private final Path fileStorageLocation = Paths.get("/home/container/resources/images/");

    @GetMapping("/image")
    public ResponseEntity<Resource> getImage(@RequestParam String filename) throws IOException {
        try {
            Path filePath = fileStorageLocation.resolve(filename).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                // Detect MIME type (image/png, image/jpeg, etc.)
                String contentType;
                try {
                    contentType = Files.probeContentType(filePath);
                } catch (IOException e) {
                    contentType = null;
                }
                if (contentType == null) {
                    contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
                }

                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .header(HttpHeaders.CONTENT_DISPOSITION,
                                "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            // Create the directory if it doesn't exist
            Path uploadPath = fileStorageLocation;
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Normalize the file name to prevent directory traversal attacks
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            // Construct the full file path
            Path filePath = uploadPath.resolve(fileName);

            // Copy the file to the target location
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded successfully: " + fileName);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file.");
        }
    }
}
