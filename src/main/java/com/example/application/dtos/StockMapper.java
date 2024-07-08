package com.example.application.dtos;

import com.example.application.dtos.stockDto.StockCreateDto;
import com.example.application.dtos.stockDto.StockReadDto;
import com.example.application.dtos.stockDto.StockUpdateDto;
import com.example.domain.stock.Stock;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface StockMapper {
    Stock toStock(StockCreateDto incomingStock);
    void updateStockFromDto(StockUpdateDto updateDto, @MappingTarget Stock stock);
    StockUpdateDto toStockUpdate(Stock stock);
    StockReadDto toStockRead(Stock stock);
    StockCreateDto toStockCreate(Stock stock);
}
