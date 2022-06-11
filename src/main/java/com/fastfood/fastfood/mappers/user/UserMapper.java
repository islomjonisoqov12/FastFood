package com.fastfood.fastfood.mappers.user;

import com.fastfood.fastfood.dtos.user.UserCreateDto;
import com.fastfood.fastfood.dtos.user.UserDto;
import com.fastfood.fastfood.dtos.user.UserUpdateDto;
import com.fastfood.fastfood.entities.user.User;
import com.fastfood.fastfood.mappers.base.AbstractMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper extends AbstractMapper<User, UserDto, UserCreateDto, UserUpdateDto> {

    User fromUpdateDto(UserUpdateDto dto, @MappingTarget User user);

    User fromCreateDto(UserCreateDto dto);

}
