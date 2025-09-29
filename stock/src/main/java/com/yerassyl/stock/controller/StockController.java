package com.yerassyl.stock.controller;

import com.yerassyl.stock.entity.ItemsWapper;
import com.yerassyl.stock.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class StockController {

    private final StockService itemService;

    public StockController(StockService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/stock")
    public ResponseEntity<ItemsWapper> getItems(){

        ItemsWapper items = new ItemsWapper(itemService.findAll());
        return ResponseEntity.ok(items);
    }
}
