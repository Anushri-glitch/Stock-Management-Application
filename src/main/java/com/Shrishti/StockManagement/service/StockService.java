package com.Shrishti.StockManagement.service;

import com.Shrishti.StockManagement.model.Stock;
import com.Shrishti.StockManagement.model.StockType;
import com.Shrishti.StockManagement.repository.IStockDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockService {

    @Autowired
    IStockDao stockDao;

    public String addStock(List<Stock> stock) {

        Iterable<Stock> stockList = stockDao.saveAll(stock);

        if(stockList != null){
            return "Added List Of Stocks!!!....";
        }
        return "could not added!!!...";

    }

    public List<Stock> getStocksBasedOnType(StockType stockType) {
        return stockDao.findByStockType(stockType);
    }

    public List<Stock> getStocksAbovePriceLowerDate(Double price, String date) {
        LocalDateTime formatDate = LocalDateTime.parse(date);
        return stockDao.findByStockPriceGreaterThanAndStockBirthDateLessThanOrderByStockName(price,formatDate);
    }

    public List<Stock> getStocksAboveMarketCap(Double capPercentage) {
        return stockDao.getStocksAboveMarketCap(capPercentage);
    }

    @Transactional
    public String updateMarketCapById(Double capPercentage, Integer stockId) {
        stockDao.updateMarketCapById(capPercentage, stockId);
        return "MarketCap Updated!!!";
    }

    @Transactional
    public String updateTypeById(StockType type, Integer stockId) {
        String enumValue = type.name();
        stockDao.modifyStockTypeById(enumValue, stockId);
        return "Stock Type Updated!!!";
    }

    @Transactional
    public String updateStockById(Stock myStock, Integer stockId) {
        stockDao.updateStockById(myStock.getStockName(),myStock.getStockPrice(),myStock.getStockBirthDate(),stockId);
        return "Stock is Updated Successfully By Id!!!";
    }

    @Transactional
    public String deleteStocksBasedOnCount(Integer count) {
        stockDao.deleteStocksBasedOnCount(count);
        return "Stock is Deleted based On Count!!!";
    }
}
