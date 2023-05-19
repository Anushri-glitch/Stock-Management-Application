package com.Shrishti.StockManagement.service;

import com.Shrishti.StockManagement.model.Stock;
import com.Shrishti.StockManagement.model.StockType;
import com.Shrishti.StockManagement.repository.IStockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    IStockDao stockDao;

    public String addStock(Stock stock) {

        if(!stockDao.existsById(stock.getStockId())){
            stockDao.save(stock);
            return stock.toString();
        }
        return "Stock Already Exists!!!";

    }

    public Stock getStocksBasedOnType(StockType stockType) {
        return stockDao.getStocksBasedOnType(stockType);
    }
}
