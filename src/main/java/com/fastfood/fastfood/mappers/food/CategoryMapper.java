package com.fastfood.fastfood.mappers.food;

import com.fastfood.fastfood.dtos.food.CategoryCreateDto;
import com.fastfood.fastfood.dtos.food.CategoryDto;
import com.fastfood.fastfood.dtos.food.CategoryUpdateDto;
import com.fastfood.fastfood.entities.foods.Category;
import com.fastfood.fastfood.mappers.base.AbstractMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoryMapper extends AbstractMapper<Category, CategoryDto, CategoryCreateDto, CategoryUpdateDto> {
    Category fromUpdateDto(CategoryUpdateDto updateDto, @MappingTarget Category category);
}
