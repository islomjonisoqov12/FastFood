package com.fastfood.fastfood.entities.order;

import com.fastfood.fastfood.entities.address.Address;
import com.fastfood.fastfood.entities.base.Auditable;
import com.fastfood.fastfood.entities.user.User;
import com.fastfood.fastfood.enums.OrderStatus;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "orders")
@Table(schema = "orders")

@TypeDefs({
        @TypeDef(name = "string-array", typeClass = StringArrayType.class),
        @TypeDef(name = "int-array", typeClass = IntArrayType.class),
        @TypeDef(name = "json", typeClass = JsonType.class)
})
public class Order extends Auditable {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long OrderNumber;

    LocalDateTime deliveredAt;

    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;

    @Column(nullable = false)
    Long TotalSum;

    @Column(nullable = false)
    Long deliveryPrice;

    Long estimatedTime;

    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    Set<OrderItem> orderItems = new HashSet<>();


    @ManyToOne
    User user;

    @ManyToOne
    User deliverer;

    @ManyToOne
    Address address;


}
