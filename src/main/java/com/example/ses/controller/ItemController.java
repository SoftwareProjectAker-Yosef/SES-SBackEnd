package com.example.ses.controller;

import com.example.ses.models.Item;
import com.example.ses.payload.ItemPayload;
import com.example.ses.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public @ResponseBody ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity<?> saveItem(@RequestBody ItemPayload itemPayload) {
        itemService.saveItem(
                Item.builder()
                        .itemName(itemPayload.getItemName())
                        .price(itemPayload.getPrice())
                        .build()
        );
        return ResponseEntity.accepted().build();
    }
}
