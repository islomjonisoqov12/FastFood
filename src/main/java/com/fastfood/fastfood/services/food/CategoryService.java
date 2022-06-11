package com.fastfood.fastfood.services.food;

import com.fastfood.fastfood.criteria.base.GenericCriteria;
import com.fastfood.fastfood.dtos.food.CategoryCreateDto;
import com.fastfood.fastfood.dtos.food.CategoryDto;
import com.fastfood.fastfood.dtos.food.CategoryUpdateDto;
import com.fastfood.fastfood.services.base.GenericCrudService;

public interface CategoryService extends GenericCrudService<CategoryDto, CategoryCreateDto, CategoryUpdateDto, String, GenericCriteria> {

}
