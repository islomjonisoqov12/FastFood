package com.fastfood.fastfood.entities.order;


import com.fastfood.fastfood.entities.base.Auditable;
import com.fastfood.fastfood.enums.PayType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "payments")
@Table(schema = "orders")
public class Payment extends Auditable {

    @OneToOne
    Order order;

    PayType payType;

    Long totalAmount;
}
