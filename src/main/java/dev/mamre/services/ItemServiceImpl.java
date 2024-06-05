package dev.mamre.services;

import dev.mamre.api.ItemsApi;
import dev.mamre.api.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemsApi {
    private List<Item> items = new ArrayList<>();

    @Override
    public ResponseEntity<List<Item>> itemsGet() {
        return ResponseEntity.ok(items);
    }

    @Override
    public ResponseEntity<Item> itemsIdGet(String id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Item> itemsPost(Item item) {
        // Implement your business logic here
        item.setId(UUID.randomUUID().toString());
        items.add(item);
        return ResponseEntity.status(201).body(item);
    }
}
