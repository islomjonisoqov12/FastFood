package com.fastfood.fastfood.exceptions.food;

import com.fastfood.fastfood.exceptions.ValidationException;

public class FoodNotFoundException extends ValidationException {

    public FoodNotFoundException(String message) {
        super(message);
    }
}
