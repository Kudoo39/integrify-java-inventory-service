package com.example.application.stock;

import com.example.domain.order.Order;
import com.example.domain.stock.IStockRepo;
import com.example.domain.stock.Stock;
import com.example.exception.customException.ResourceNotFound;
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
        Stock stock = stockRepo.getStockById(id);
        if (stock == null) {
            throw new ResourceNotFound("Stock not found with id: " + id);
        }
        return stock;
    }

    @Override
    public Stock updateStock(UUID id, Stock stock) {
        Stock existingStock = stockRepo.getStockById(id);
        if (existingStock == null) {
            throw new ResourceNotFound("Stock not found with id: " + id);
        }
        return stockRepo.updateStock(id, stock);
    }

    @Override
    public void deleteStock(UUID id) {
        Stock stock = stockRepo.getStockById(id);
        if (stock == null) {
            throw new ResourceNotFound("Stock not found with id: " + id);
        }
        stockRepo.deleteStock(id);
    }
}
