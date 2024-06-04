package com.cfprac.controller;

import com.cfprac.service.FileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/reconResultExcel")
    public File getReconResultInExcel() throws IOException {
        return fileService.getReconResultsInExcel();
    }

}
