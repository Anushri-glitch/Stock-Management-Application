package com.Shrishti.StockManagement.controller;

import com.Shrishti.StockManagement.model.Stock;
import com.Shrishti.StockManagement.model.StockType;
import com.Shrishti.StockManagement.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    //Add New Stocks
    @PostMapping(value = "/stock")
    private String addStock(@RequestBody Stock stock){
        return stockService.addStock(stock);
    }

    //Get Stocks Based On Type
    @GetMapping(value = "/stockType")
    private Stock getStocksBasedOnType(@RequestParam StockType stockType){
        return stockService.getStocksBasedOnType(stockType);
    }
}
