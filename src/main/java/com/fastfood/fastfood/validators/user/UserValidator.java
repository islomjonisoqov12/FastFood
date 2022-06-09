package com.fastfood.fastfood.validators.user;

import com.fastfood.fastfood.dtos.user.UserCreateDto;
import com.fastfood.fastfood.dtos.user.UserUpdateDto;
import com.fastfood.fastfood.validators.base.AbstractValidator;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class UserValidator extends AbstractValidator<UserCreateDto, UserUpdateDto, String> {
    @Override
    public void validateKey(String id) throws ValidationException {

    }

    @Override
    public void validOnCreate(UserCreateDto userCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(UserUpdateDto cd) throws ValidationException {

    }
}
