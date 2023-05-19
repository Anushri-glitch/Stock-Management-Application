package com.Shrishti.StockManagement.controller;

import com.Shrishti.StockManagement.model.Stock;
import com.Shrishti.StockManagement.model.StockType;
import com.Shrishti.StockManagement.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    //Add New Stocks
    @PostMapping(value = "/stock")
    private String addStock(@RequestBody List<Stock> stock){
        return stockService.addStock(stock);
    }

    //Get Stocks Based On Type
    @GetMapping(value = "/stockType")
    private List<Stock> getStocksBasedOnType(@RequestParam StockType stockType){
        return stockService.getStocksBasedOnType(stockType);
    }

    //Get Stocks Above Price and Lower Date
    @GetMapping(value = "/abovePrice/price/{price}/lowerDate/date/{date}")
    private List<Stock> getStocksAbovePriceLowerDate(@PathVariable Double price , @PathVariable String date){
        return stockService.getStocksAbovePriceLowerDate(price,date);
    }

    //Get All Stocks Above MarketCap
    @GetMapping(value = "/cap/{capPercentage}")
    private List<Stock> getStocksAboveMarketCap(@PathVariable Double capPercentage){
        return stockService.getStocksAboveMarketCap(capPercentage);
    }

    //Update MarketCap By StockId
    @PutMapping(value = "/cap/{capPercentage}/stockId/{stockId}")
    private String updateMarketCapById(@PathVariable Double capPercentage, @PathVariable Integer stockId){
        return stockService.updateMarketCapById(capPercentage, stockId);
    }

    //Update Type By StockId
    @PutMapping(value = "/type/{type}/stockId/{stockId}")
    private String updateTypeById(@PathVariable StockType type, @PathVariable Integer stockId){
        return stockService.updateTypeById(type,stockId);
    }

    //Update Stocks By Id
    @PutMapping(value = "/stock/{stockId}")
    public String updateStockById(@RequestBody Stock myStock, @PathVariable Integer stockId)
    {
        return stockService.updateStockById(myStock, stockId);
    }

    //Delete Stocks where OwnerCount is Less Than or Equal to Given OwnerCount
    @DeleteMapping(value = "/ownerCount/{count}")
    public String removeStocksByOwnerCount(@PathVariable  Integer count)
    {
        return stockService.deleteStocksBasedOnCount(count);
    }
}
