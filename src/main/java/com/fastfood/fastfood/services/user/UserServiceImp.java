package com.fastfood.fastfood.services.user;

//import com.fastfood.fastfood.criteria.base.BaseGenericCriteria;
//import com.fastfood.fastfood.dtos.user.UserCreateDto;
//import com.fastfood.fastfood.dtos.user.UserDto;
//import com.fastfood.fastfood.dtos.user.UserUpdateDto;
//import com.fastfood.fastfood.mappers.user.UserMapper;
//import com.fastfood.fastfood.repositories.user.UserRepository;
//import com.fastfood.fastfood.services.base.AbstractService;
//import com.fastfood.fastfood.validators.user.UserValidator;
import com.fastfood.fastfood.criteria.base.BaseGenericCriteria;
import com.fastfood.fastfood.dtos.user.UserCreateDto;
import com.fastfood.fastfood.dtos.user.UserDto;
import com.fastfood.fastfood.dtos.user.UserUpdateDto;
import com.fastfood.fastfood.mappers.user.UserMapper;
import com.fastfood.fastfood.repositories.user.UserRepository;
import com.fastfood.fastfood.services.base.AbstractService;
import com.fastfood.fastfood.validators.user.UserValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp extends AbstractService<
        UserRepository,
        UserMapper,
        UserValidator
        > implements UserService {

    protected UserServiceImp(UserMapper mapper, UserValidator validator, UserRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public String create(UserCreateDto dto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(UserUpdateDto dto) {

    }

    @Override
    public UserDto get(String id) {
        return null;
    }

    @Override
    public List<UserDto> getAll(BaseGenericCriteria criteria) {
        return null;
    }
}
