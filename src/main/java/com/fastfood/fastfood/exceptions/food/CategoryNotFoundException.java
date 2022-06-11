package com.fastfood.fastfood.exceptions.food;

import com.fastfood.fastfood.exceptions.ValidationException;

public class CategoryNotFoundException extends ValidationException {

    public CategoryNotFoundException(String message) {
        super(message);
    }

    public CategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
