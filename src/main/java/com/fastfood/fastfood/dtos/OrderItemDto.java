package com.fastfood.fastfood.dtos;


import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderItemDto {

    String foodId;

    Integer quantity;
}
