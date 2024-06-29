package com.example.demo.image.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.image.Service.ImageService;
import com.example.demo.image.entity.Image;

@RestController
@RequestMapping("/api/images")
public class ImageController {
	@Autowired
	private ImageService imageService;
	@PostMapping
	public ResponseEntity<Image>uploadImage(@RequestParam("file")MultipartFile file){
		try {
			Image image = imageService.saveImage(file);
			return new ResponseEntity<>(image,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<byte[]> getImage (@PathVariable Long id){
		Image image = imageService.getImage(id);
				return  ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(image.getData());

	}
	
}
