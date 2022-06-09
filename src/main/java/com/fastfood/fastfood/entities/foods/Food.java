package com.fastfood.fastfood.entities.foods;

import com.fastfood.fastfood.entities.base.AbsNameEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "foods")
@Table(schema = "food")
public class Food extends AbsNameEntity {

    @Column(nullable = false)
    Long price;

    @Column(nullable = false)
    String imageLink;

    LocalDateTime availableFrom;

    LocalDateTime availableTo;

    Integer preparationTimeInMin;

    @ManyToOne
    Category category;
}
