package com.fastfood.fastfood.services.base;

import com.fastfood.fastfood.mappers.base.BaseGenericMapper;
import com.fastfood.fastfood.repositories.base.BaseGenericRepository;
import com.fastfood.fastfood.validators.base.BaseGenericValidator;

public abstract class AbstractService<
        R extends BaseGenericRepository,
        M extends BaseGenericMapper,
        V extends BaseGenericValidator
        > implements BaseGenericService {

    protected final M mapper;
    protected final V validator;
    protected final R repository;

    protected AbstractService(M mapper, V validator, R repository) {
        this.mapper = mapper;
        this.validator = validator;
        this.repository = repository;
    }

}
