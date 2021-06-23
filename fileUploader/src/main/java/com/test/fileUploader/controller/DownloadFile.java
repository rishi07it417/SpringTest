package com.test.fileUploader.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.fileUploader.service.FileService;

@RestController
public class DownloadFile {
	@Autowired
	FileService fileService;

	@GetMapping("/FileUploader/download/{fileName}")
	void downloadFile(@PathVariable("fileName")String fileName,HttpServletResponse res){
		
		res.setStatus(200);
		res.setContentType("pdf");
		res.addHeader("ContentDisposition","attachment; filename="+fileName);

		byte[] s = fileService.collectFile(fileName);
		try {
		res.getOutputStream().write(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@GetMapping("/FileUploader/downloadMultiple")
	void downloadMultipleFiles(@RequestParam("fileNames")String fileNames,HttpServletResponse res){
		
		res.setStatus(200);
		res.setContentType("zip");
		res.addHeader("ContentDisposition","attachment");
		
		try {
			ZipOutputStream zout = new ZipOutputStream(res.getOutputStream());

			List<String>files =Arrays.asList(fileNames.split(","));
				files.forEach(file->{
					Path path = Paths.get("FileStorage/"+file);
					File fileToZip = path.toAbsolutePath().toFile();
					ZipEntry zip = new ZipEntry(fileToZip.getName());
					zip.setSize(fileToZip.getUsableSpace());
					try {
						zout.putNextEntry(zip);
						Files.copy(path, zout);
						zout.closeEntry();

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				});
				
				zout.finish();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
