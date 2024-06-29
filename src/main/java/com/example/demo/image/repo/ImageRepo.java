package com.example.demo.image.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.image.entity.Image;

public interface ImageRepo extends JpaRepository<Image, Long> {

}
