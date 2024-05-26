package com.poly.assignment.service;

import jakarta.servlet.ServletContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileUploadService {

    private final ServletContext servletContext;

    public String uploadFile(MultipartFile multipartFile) throws IOException {
        if (multipartFile != null && !multipartFile.isEmpty()) {

            String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            String uploadDir = servletContext.getRealPath("/WEB-INF/public/upload");

            File uploadDirectory = new File(uploadDir);
            if (!uploadDirectory.exists()) {
                uploadDirectory.mkdirs();
            }

            File file = new File(uploadDirectory, filename);
            multipartFile.transferTo(file);

            return "http://localhost:9999/public/upload/" + filename;
        }
        return null;
    }

}
