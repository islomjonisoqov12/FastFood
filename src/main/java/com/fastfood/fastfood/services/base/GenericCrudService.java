package com.fastfood.fastfood.services.base;

import com.fastfood.fastfood.criteria.base.BaseGenericCriteria;
import com.fastfood.fastfood.dtos.base.BaseGenericDto;
import com.fastfood.fastfood.dtos.base.GenericDto;

import java.io.Serializable;

public interface GenericCrudService<
        D extends GenericDto,
        CD extends BaseGenericDto,
        UD extends GenericDto,
        K extends Serializable,
        C extends BaseGenericCriteria
        > extends GenericService<D, K, C> {
    K create(CD dto);

    void delete(K id);

    void update(UD dto);
}
