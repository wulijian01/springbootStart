package com.springboot.start.springbootStart.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UploadController {
	
	private static final String UPLOAD_FLOAD="D:\\upload\\";

	@PostMapping("/uploadSign")
	public String fileUpload(
			@RequestParam("file")
			MultipartFile file,
			RedirectAttributes redirectAttributes
			) {
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "请选择一个文件上传！");
			return "redirect:/uploadStatus";
		}
		
		try {
			byte[] fileBytes = file.getBytes();
			
			Path path = Paths.get(UPLOAD_FLOAD+file.getOriginalFilename());
			
			Files.write(path, fileBytes);
			
			redirectAttributes.addFlashAttribute("message", "上传文件"+file.getOriginalFilename()+"成功！");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/uploadStatus";
	}
	
	
	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		
		return "uploadStatus";
	}
	
	@GetMapping("/fromFile")
	public String fromFile() {
		
		return "from_file";
	}
}
