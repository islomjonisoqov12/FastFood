package com.fastfood.fastfood.mappers.base;


import com.fastfood.fastfood.dtos.base.BaseGenericDto;
import com.fastfood.fastfood.dtos.base.GenericDto;
import com.fastfood.fastfood.entities.base.BaseGenericEntity;

import java.util.List;

public interface AbstractMapper<
        E extends BaseGenericEntity,
        D extends GenericDto,
        CD extends BaseGenericDto,
        UP extends GenericDto
        > extends BaseGenericMapper {
    D toDto(E entity);

    List<D> toDto(List<E> entities);

    E fromCreateDto(CD createDto);

    E fromUpdateDto(UP updateDto);
}
