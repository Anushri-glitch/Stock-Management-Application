package com.Shrishti.StockManagement.repository;

import com.Shrishti.StockManagement.model.Stock;
import com.Shrishti.StockManagement.model.StockType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IStockDao extends JpaRepository<Stock,Integer> {


    List<Stock> findByStockType(StockType stockType);

    List<Stock> findByStockPriceGreaterThanAndStockBirthDateLessThanOrderByStockName(Double price, LocalDateTime formatDate);

    @Query(value = "select * from stock where stock_market_cap > :capPercentage", nativeQuery = true)
    List<Stock> getStocksAboveMarketCap(Double capPercentage);

    @Modifying
    @Query(value = "update stock set stock_market_cap = :capPercentage where stock_id = :stockId", nativeQuery = true)
    void updateMarketCapById(Double capPercentage, Integer stockId);

    @Modifying
    @Query(value = "update stock set stock_type = :enumValue where stock_id = :stockId", nativeQuery = true)
    void modifyStockTypeById(String enumValue, Integer stockId);

    @Modifying
    @Query(value = "update stock set stock_name = :stockName, stock_price= :stockPrice, stock_birth_date = :stockBirthDate where stock_id = :newStockId",nativeQuery = true)
    void updateStockById(String stockName, Double stockPrice, LocalDateTime stockBirthDate, Integer newStockId);

    @Modifying
    @Query(value = "delete from stock where stock_owner_count <= :count", nativeQuery = true)
    void deleteStocksBasedOnCount(Integer count);
}
