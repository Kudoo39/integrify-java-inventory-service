package com.example.infrastructure.stock;

import com.example.domain.stock.IStockRepo;
import com.example.domain.stock.Stock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class StockRepo implements IStockRepo {
    @Autowired
    private IStockJpaRepo stockRepo;

    public List<Stock> getAllStocks() {
        return stockRepo.findAll();
    }

    public Stock getStockById(UUID id) {
        return stockRepo.findById(id).orElse(null);
    }

    public Stock createStock(Stock stock) {
        return stockRepo.save(stock);
    }

    public Stock updateStock(UUID id, Stock stock) {
        if (stockRepo.existsById(id)) {
            stock.setId(id);
            return stockRepo.save(stock);
        }
        return null;
    }

    public void deleteStock(UUID id) {
        stockRepo.deleteById(id);
    }
}
