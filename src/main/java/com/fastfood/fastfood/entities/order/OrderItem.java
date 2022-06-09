package com.fastfood.fastfood.entities.order;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderItem {

    @NotNull @NotEmpty @NotBlank
    String foodId;

    @NotNull
    Integer quantity;
}
