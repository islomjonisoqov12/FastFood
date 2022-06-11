package com.fastfood.fastfood.entities.order;

import com.fastfood.fastfood.entities.base.Auditable;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "feedbacks")
@Table(schema = "orders")
public class FeedBack extends Auditable {

    @ManyToOne
    Order order;

    String text;

    byte rate;
}
