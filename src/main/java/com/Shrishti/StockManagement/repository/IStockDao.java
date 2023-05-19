package com.Shrishti.StockManagement.repository;

import com.Shrishti.StockManagement.model.Stock;
import com.Shrishti.StockManagement.model.StockType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockDao extends JpaRepository<Stock,Integer> {
    Stock getStocksBasedOnType(StockType stockType);
}
