package com.example.application.stock;

import com.example.domain.stock.Stock;

import java.util.List;
import java.util.UUID;

public interface IStockService {
    public List<Stock> getAllStocks();
    public Stock createStock(Stock stock);
    public Stock getStockById(UUID id);
    public Stock updateStock(UUID id, Stock stock);
    public void deleteStock(UUID id);
    public List<Stock> getStocksBySupplierId(UUID supplierId);
    public List<Stock> getStocksByProductId(UUID productId);
    public List<Stock> getLowStockAlerts(int threshold);
}
