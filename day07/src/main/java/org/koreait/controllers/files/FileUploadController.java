package org.koreait.controllers.files;

import java.io.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/file/upload")
public class FileUploadController {
	
	@Value("${file.uploadPath}")
	private String uploadPath;
	
	@GetMapping
	public String upload() {
		
		return "file/upload";
	}
	
	@PostMapping
	public String uploadPs(MultipartFile[] files) {
		for (MultipartFile file : files) {
			String path = uploadPath + file.getOriginalFilename();
			File uploadFile = new File(path);
			try {
				file.transferTo(uploadFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return "file/upload";
	}
	/**
	public String uploadPs(MultipartFile file) {
		String path = "D:\\uploads\\" + file.getOriginalFilename();
		File uploadFile = new File(path);
		try {
			file.transferTo(uploadFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "file/upload";
 	}
 	*/
}
