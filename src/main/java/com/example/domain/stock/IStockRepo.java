package com.example.domain.stock;

import com.example.application.dtos.stockDto.StockReadDto;

import java.util.List;
import java.util.UUID;

public interface IStockRepo {
    public List<StockReadDto> getAllStocks();
    public Stock createStock(Stock stock);
    public Stock getStockById(UUID id);
    public Stock updateStock(Stock stock);
    public void deleteStock(UUID id);
    public List<Stock> getStocksBySupplierId(UUID supplierId);
    public List<Stock> getStocksByProductId(UUID productId);
    public List<Stock> getLowStockAlerts(int threshold);
}
