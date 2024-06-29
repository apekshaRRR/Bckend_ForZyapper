package com.example.demo.image.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.image.Service.ItemService;
import com.example.demo.image.entity.Item;

@RestController
@RequestMapping("/api/inventry")
public class InventryController {
@Autowired
	private ItemService itemService;

@PostMapping
	public ResponseEntity<Item> createItem(@RequestBody Item item){
		Item newItem = itemService.createItem(item);
		return new ResponseEntity<>(newItem,HttpStatus.OK);
	}
@PutMapping("/{id}")
public ResponseEntity<Item> updateItem(@PathVariable Long id,@RequestBody Item itemDetails ){
	Item updateItem = itemService.updateItem(id, itemDetails);
	if (updateItem != null) {
		return new ResponseEntity<>(updateItem,HttpStatus.OK);

	}else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
}

@GetMapping
public ResponseEntity<List<Item>> getAllItem(){
	List<Item> items = itemService.getAllItems();
	
		return new ResponseEntity<>(items,HttpStatus.OK);	
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteItem(@PathVariable Long id){
	 itemService.deleteItem(id);
	
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
}

@GetMapping("/{id}")
public ResponseEntity<Item> getItem(@PathVariable Long id){
	Item items = itemService.getItem(id);
	
		return new ResponseEntity<>(items,HttpStatus.OK);	
}
}
