package com.fastfood.fastfood.dtos.food;

import com.fastfood.fastfood.dtos.base.GenericDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class FoodDto extends GenericDto {
    String id;
    String name;
    String description;
    LocalTime availableFrom;
    LocalTime availableTo;
    String imageLink;
    Integer preparationTimeInMin;
    Long price;

// TODO: 6/9/2022 validation
}
