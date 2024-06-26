package com.example.infrastructure.stock;

import com.example.domain.stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IStockJpaRepo extends JpaRepository<Stock, UUID> {
    public List<Stock> getStocksBySupplier(UUID supplierId);
    public List<Stock> getStocksByProductIdentifier(String productIdentifier);
    public List<Stock> getLowStockAlerts(int threshold);
}
