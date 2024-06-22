package com.example.application.stock;

import com.example.domain.stock.IStockRepo;
import com.example.domain.stock.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StockService implements IStockService{
    @Autowired
    private IStockRepo stockRepo;

    @Override
    public List<Stock> getAllStocks() {
        return stockRepo.getAllStocks();
    }

    @Override
    public Stock createStock(Stock stock) {
        return stockRepo.createStock(stock);
    }

    @Override
    public Stock getStockById(UUID id) {
        return stockRepo.getStockById(id);
    }

    @Override
    public Stock updateStock(UUID id, Stock stock) {
        return stockRepo.updateStock(id, stock);
    }

    @Override
    public void deleteStock(UUID id) {
        stockRepo.deleteStock(id);
    }
}
