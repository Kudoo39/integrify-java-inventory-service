package com.example.application.stock;

import com.example.application.dtos.stockDto.StockCreateDto;
import com.example.application.dtos.stockDto.StockReadDto;
import com.example.application.dtos.stockDto.StockUpdateDto;
import com.example.application.dtos.supplierDto.SupplierReadDto;
import com.example.domain.order.Order;
import com.example.domain.stock.IStockRepo;
import com.example.domain.stock.Stock;
import com.example.domain.supplier.ISupplierRepo;
import com.example.presentation.customException.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StockService implements IStockService{
    @Autowired
    private IStockRepo stockRepo;

    @Autowired
    private ISupplierRepo supplierRepo;

    @Override
    public List<StockReadDto> getAllStocks() {
        return stockRepo.getAllStocks();
    }

    @Override
    public StockCreateDto createStock(StockCreateDto stock) {
        UUID supplierId = stock.getSupplierId();
        SupplierReadDto supplier = supplierRepo.getSupplierById(supplierId);
        if (supplier == null) {
            throw new ResourceNotFound("Supplier not found with id: " + supplierId);
        }
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
    public StockReadDto updateStock(UUID id, StockUpdateDto stock) {
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

    @Override
    public List<Stock> getStocksBySupplierId(UUID supplierId) {
        return stockRepo.getStocksBySupplierId(supplierId);
    }

    @Override
    public List<Stock> getStocksByProductId(UUID productId) {
        return stockRepo.getStocksByProductId(productId);
    }

    @Override
    public List<Stock> getLowStockAlerts(int threshold) {
        return stockRepo.getLowStockAlerts(threshold);
    }
}
