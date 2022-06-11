package com.fastfood.fastfood.entities.foods;

import com.fastfood.fastfood.entities.base.AbsNameEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "foods")
@Table(schema = "food", uniqueConstraints = {})
public class Food extends AbsNameEntity {

    @Column(nullable = false)
    Long price;

    @Column(nullable = false)
    String imageLink;

    LocalTime availableFrom;

    LocalTime availableTo;

    Integer preparationTimeInMin;

    @ManyToOne
    Category category;
}
