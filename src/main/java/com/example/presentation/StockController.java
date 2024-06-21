package com.example.presentation;

import com.example.application.stock.IStockService;
import com.example.domain.stock.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {
    @Autowired
    private IStockService stockService;

    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        List<Stock> stocks = stockService.getAllStocks();
        return ResponseEntity.ok(stocks);
    }

    @PostMapping
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        Stock createdStock = stockService.createStock(stock);
        // created
        return ResponseEntity.ok(createdStock);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable UUID id) {
        try {
            Stock stock = stockService.getStockById(id);
            return ResponseEntity.ok(stock);
        } catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable UUID id, @RequestBody Stock stock) {
        try {
            Stock updatedStock = stockService.updateStock(id, stock);
            return ResponseEntity.ok(updatedStock);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable UUID id) {
        try {
            stockService.deleteStock(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
