package com.fastfood.fastfood.mappers;

import com.fastfood.fastfood.dtos.OrderItemDto;
import com.fastfood.fastfood.entities.order.OrderItem;
import org.mapstruct.Mapper;

@Mapper
public interface OrderItemMapper {

    OrderItem getToDto(OrderItemDto dto);

}
