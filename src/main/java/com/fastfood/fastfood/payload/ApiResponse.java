package com.fastfood.fastfood.payload;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse<T> {

    String message;

    T data;

    boolean success;
}
