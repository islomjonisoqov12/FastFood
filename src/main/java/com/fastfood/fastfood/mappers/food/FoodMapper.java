package com.fastfood.fastfood.mappers.food;

import com.fastfood.fastfood.dtos.food.FoodCreatDto;
import com.fastfood.fastfood.dtos.food.FoodDto;
import com.fastfood.fastfood.dtos.food.FoodUpdateDto;
import com.fastfood.fastfood.entities.foods.Food;
import com.fastfood.fastfood.mappers.base.AbstractMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FoodMapper extends AbstractMapper<
        Food,
        FoodDto,
        FoodCreatDto,
        FoodUpdateDto
        > {

    @Override
    FoodDto toDto(Food entity);

    @Override
    List<FoodDto> toDto(List<Food> entities);

    @Override
    Food fromCreateDto(FoodCreatDto createDto);

    @Override
    Food fromUpdateDto(FoodUpdateDto updateDto);
}
