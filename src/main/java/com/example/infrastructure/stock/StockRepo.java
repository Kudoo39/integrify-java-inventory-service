package com.example.infrastructure.stock;

import com.example.domain.stock.IStockRepo;
import com.example.domain.stock.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class StockRepo implements IStockRepo {
    @Autowired
    private IStockJpaRepo stockRepo;

    @Override
    public List<Stock> getAllStocks() {
        return stockRepo.findAll();
    }

    @Override
    public Stock getStockById(UUID id) {
        return stockRepo.findById(id).orElse(null);
    }

    @Override
    public Stock createStock(Stock stock) {
        return stockRepo.save(stock);
    }

    @Override
    public Stock updateStock(UUID id, Stock stock) {
        if (stockRepo.existsById(id)) {
            stock.setId(id);
            return stockRepo.save(stock);
        }
        return null;
    }

    @Override
    public void deleteStock(UUID id) {
        stockRepo.deleteById(id);
    }
}
