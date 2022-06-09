package com.fastfood.fastfood.services.base;

import com.fastfood.fastfood.criteria.base.BaseGenericCriteria;
import com.fastfood.fastfood.dtos.base.BaseGenericDto;

import java.io.Serializable;
import java.util.List;

public interface GenericService<
        D extends BaseGenericDto,
        K extends Serializable,
        C extends BaseGenericCriteria
        > extends BaseGenericService {

    D get(K id);

    List<D> getAll(C criteria);

}