package com.Shrishti.StockManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer stockId;

    private String stockName;
    private Double stockPrice;
    private LocalDateTime stockBirthDate;
    private Integer stockOwnerCount;

    @Enumerated(EnumType.STRING)
    private StockType StockType;
    private Double stockMarketCap;
}
