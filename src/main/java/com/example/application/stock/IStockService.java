package com.example.application.stock;

import com.example.application.dtos.stockDto.StockCreateDto;
import com.example.application.dtos.stockDto.StockReadDto;
import com.example.application.dtos.stockDto.StockUpdateDto;
import com.example.domain.stock.Stock;

import java.util.List;
import java.util.UUID;

public interface IStockService {
    public List<StockReadDto> getAllStocks();
    public StockCreateDto createStock(StockCreateDto stock);
    public Stock getStockById(UUID id);
    public StockReadDto updateStock(UUID id, StockUpdateDto stock);
    public void deleteStock(UUID id);
    public List<Stock> getStocksBySupplierId(UUID supplierId);
    public List<Stock> getStocksByProductId(UUID productId);
    public List<Stock> getLowStockAlerts(int threshold);
}
