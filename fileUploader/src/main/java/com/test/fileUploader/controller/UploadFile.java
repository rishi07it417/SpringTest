package com.test.fileUploader.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.fileUploader.model.FileToken;
import com.test.fileUploader.service.FileService;

@RestController
public class UploadFile {
	
	@Autowired
	FileService fileService;
	
	@PostMapping("/FileUploader/upload")
	FileToken uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest req) {
		FileToken fileInfo = null;
		String uri = req.getContextPath()+"/FileUploader/download/"+file.getOriginalFilename();
		fileService.storeFile(file);
		fileInfo = new FileToken(file.getOriginalFilename(),file.getContentType(),uri);
		
		return fileInfo;
	}
	
	@PostMapping("/FileUploader/uploadMultiple")
	List<FileToken> uploadMultipleFile(@RequestParam("files") MultipartFile files[], HttpServletRequest req) {
		List<FileToken>fileToken = new ArrayList<FileToken>();
		Arrays.asList(files).stream().forEach(file->{
			fileService.storeFile(file);
			fileToken.add(new FileToken(file.getOriginalFilename(),file.getContentType(),req.getContextPath()+"/FileUploader/download/"+file.getOriginalFilename()));
		});
		
		return fileToken;
	}

}
