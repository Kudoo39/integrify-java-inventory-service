package com.example.application.dtos;

import com.example.application.dtos.stockDto.StockCreateDto;
import com.example.application.dtos.stockDto.StockReadDto;
import com.example.domain.stock.Stock;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface StockMapper {
    Stock toStock(StockCreateDto incomingStock);
    StockReadDto toStockRead(Stock stock);
}
