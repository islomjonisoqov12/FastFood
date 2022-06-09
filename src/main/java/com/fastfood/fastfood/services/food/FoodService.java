package com.fastfood.fastfood.services.food;

import com.fastfood.fastfood.criteria.base.GenericCriteria;
import com.fastfood.fastfood.dtos.food.FoodCreatDto;
import com.fastfood.fastfood.dtos.food.FoodDto;
import com.fastfood.fastfood.dtos.food.FoodUpdateDto;
import com.fastfood.fastfood.services.base.GenericCrudService;

import java.util.List;

public interface FoodService extends GenericCrudService<FoodDto, FoodCreatDto, FoodUpdateDto, String, GenericCriteria> {

    List<FoodDto> getAllByCategoryId(String categoryId);
}
