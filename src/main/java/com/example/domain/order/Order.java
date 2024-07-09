package com.example.domain.order;

        import com.example.domain.orderItem.OrderItem;
        import jakarta.persistence.*;
        import lombok.*;
        import com.example.domain.supplier.Supplier;

        import java.util.Date;
        import java.util.List;
        import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"order\"")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @Transient
    private List<OrderItem> orderItems;
}
