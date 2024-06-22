package com.example.domain.stock;

import jakarta.persistence.*;
import lombok.*;
import com.example.domain.supplier.Supplier;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "\"stock\"")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String productIdentifier;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
