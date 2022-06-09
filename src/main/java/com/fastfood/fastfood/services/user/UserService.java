package com.fastfood.fastfood.services.user;


//import com.fastfood.fastfood.criteria.base.BaseGenericCriteria;
//import com.fastfood.fastfood.dtos.user.UserCreateDto;
//import com.fastfood.fastfood.dtos.user.UserDto;
//import com.fastfood.fastfood.dtos.user.UserUpdateDto;
//import com.fastfood.fastfood.services.base.GenericCrudService;

import com.fastfood.fastfood.criteria.base.BaseGenericCriteria;
import com.fastfood.fastfood.dtos.user.UserCreateDto;
import com.fastfood.fastfood.dtos.user.UserDto;
import com.fastfood.fastfood.dtos.user.UserUpdateDto;
import com.fastfood.fastfood.services.base.GenericCrudService;

public interface UserService extends GenericCrudService<
        UserDto,
        UserCreateDto,
        UserUpdateDto,
        String,
        BaseGenericCriteria
        > {

}
