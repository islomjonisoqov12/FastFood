package com.fastfood.fastfood.mappers.user;

import com.fastfood.fastfood.dtos.user.UserCreateDto;
import com.fastfood.fastfood.dtos.user.UserDto;
import com.fastfood.fastfood.dtos.user.UserUpdateDto;
import com.fastfood.fastfood.entities.user.User;
import com.fastfood.fastfood.mappers.base.AbstractMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper extends AbstractMapper<User, UserDto, UserCreateDto, UserUpdateDto> {
}
