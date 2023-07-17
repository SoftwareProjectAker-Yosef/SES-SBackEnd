package com.example.SES.services;


import com.example.SES.models.Item;
import com.example.SES.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepo itemRepo;

    public List<Item> getAllItems() {
        return itemRepo.findAll();

    }

    public void saveItem(Item item) {
        itemRepo.save(item);
    }
}
