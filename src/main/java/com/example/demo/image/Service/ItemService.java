package com.example.demo.image.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.image.entity.Item;
import com.example.demo.image.repo.ItemRepo;
@Service
public class ItemService {
    @Autowired
    private ItemRepo itemRepository;

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item itemDetails) {
        Item item = itemRepository.findById(id).orElse(null);
        if (item != null) {
            item.setName(itemDetails.getName());
            item.setCategory(itemDetails.getCategory());
            item.setQuntity(itemDetails.getQuntity());
            return itemRepository.save(item);
        }
        return null;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public Item getItem(Long id) {
        return itemRepository.findById(id).orElse(null);
    }
}
