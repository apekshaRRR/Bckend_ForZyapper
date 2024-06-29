package com.example.demo.image.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.image.entity.Image;
import com.example.demo.image.repo.ImageRepo;

@Service
public class ImageService {
	@Autowired
	private ImageRepo imageRepo;
	public Image saveImage(MultipartFile file) throws IOException {
		
		Image image = new Image();
		image.setName(file.getOriginalFilename());
		image.setData(file.getBytes());
		return imageRepo.save(image);
	}
	public Image getImage(long id) {
		return imageRepo.findById(id).orElse(null);
	}

}
