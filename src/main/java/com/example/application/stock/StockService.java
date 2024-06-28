package com.example.application.stock;

import com.example.domain.order.Order;
import com.example.domain.stock.IStockRepo;
import com.example.domain.stock.Stock;
import com.example.domain.supplier.ISupplierRepo;
import com.example.domain.supplier.Supplier;
import com.example.exception.customException.ResourceNotFound;
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
    public List<Stock> getAllStocks() {
        return stockRepo.getAllStocks();
    }

    @Override
    public Stock createStock(Stock stock) {
        UUID supplierId = stock.getSupplier().getId();
        Supplier supplier = supplierRepo.getSupplierById(supplierId);
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
    public Stock updateStock(UUID id, Stock stock) {
        Stock existingStock = stockRepo.getStockById(id);
        if (existingStock == null) {
            throw new ResourceNotFound("Stock not found with id: " + id);
        }
        existingStock.setProductId(stock.getProductId());
        existingStock.setQuantity(stock.getQuantity());

        UUID supplierId = stock.getSupplier().getId();
        Supplier supplier = supplierRepo.getSupplierById(supplierId);
        if (supplier == null) {
            throw new ResourceNotFound("Supplier not found with id: " + supplierId);
        }
        existingStock.setSupplier(supplier);

        return stockRepo.updateStock(existingStock);
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
