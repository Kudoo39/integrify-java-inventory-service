package com.example.domain.stock;

import com.example.application.dtos.stockDto.StockCreateDto;
import com.example.application.dtos.stockDto.StockReadDto;
import com.example.application.dtos.stockDto.StockUpdateDto;

import java.util.List;
import java.util.UUID;

public interface IStockRepo {
    public List<StockReadDto> getAllStocks();
    public StockCreateDto createStock(StockCreateDto stock);
    public Stock getStockById(UUID id);
    public StockReadDto updateStock(UUID id, StockUpdateDto stock);
    public void deleteStock(UUID id);
    public List<Stock> getStocksBySupplierId(UUID supplierId);
    public List<Stock> getStocksByProductId(UUID productId);
    public List<Stock> getLowStockAlerts(int threshold);
}
