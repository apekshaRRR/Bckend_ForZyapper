package com.example.demo.image.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.image.entity.Item;

public interface ItemRepo extends JpaRepository<Item, Long> {

}
