package com.example.infrastructure.stock;

import com.example.application.dtos.StockMapper;
import com.example.application.dtos.stockDto.StockReadDto;
import com.example.domain.stock.IStockRepo;
import com.example.domain.stock.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class StockRepo implements IStockRepo {
    @Autowired
    private IStockJpaRepo stockJpaRepo;

    @Autowired
    private StockMapper stockMapper;

    @Override
    public List<StockReadDto> getAllStocks() {
        List<Stock> stocks = stockJpaRepo.findAll();
        List<StockReadDto> stockDtos = new ArrayList<>();

        for (Stock stock : stocks) {
            StockReadDto stockDto = stockMapper.toStockRead(stock);
            stockDtos.add(stockDto);
        }

        return stockDtos;
    }

    @Override
    public Stock getStockById(UUID id) {
        return stockJpaRepo.findById(id).orElse(null);
    }

    @Override
    public Stock createStock(Stock stock) {
        return stockJpaRepo.save(stock);
    }

    @Override
    public Stock updateStock(Stock stock) {
        return stockJpaRepo.save(stock);
    }

    @Override
    public void deleteStock(UUID id) {
        stockJpaRepo.deleteById(id);
    }

    @Override
    public List<Stock> getStocksBySupplierId(UUID supplierId) {
        return stockJpaRepo.getStocksBySupplierId(supplierId);
    }

    @Override
    public List<Stock> getStocksByProductId(UUID getStocksByProductId) {
        return stockJpaRepo.getStocksByProductId(getStocksByProductId);
    };

    @Override
    public List<Stock> getLowStockAlerts(int threshold) {
        return stockJpaRepo.getLowStockAlerts(threshold);
    };
}
