package com.fastfood.fastfood.entities.order;

import com.fastfood.fastfood.entities.base.Auditable;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "delivery_pricing")
@Table(schema = "orders")
public class DeliveryPricing extends Auditable {
    Long initial_delivery_price;

    Integer initial_price_per_km;


    @Builder(builderMethodName = "childBuilder")
    public DeliveryPricing(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy, boolean deleted, short status, Long initial_delivery_price, Integer initial_price_per_km) {
        super(id, createdAt, updatedAt, createdBy, updatedBy, deleted, status);
        this.initial_delivery_price = initial_delivery_price;
        this.initial_price_per_km = initial_price_per_km;
    }


}
