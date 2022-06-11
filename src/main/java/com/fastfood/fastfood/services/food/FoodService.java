package com.fastfood.fastfood.services.food;

import com.fastfood.fastfood.criteria.base.GenericCriteria;
import com.fastfood.fastfood.dtos.food.FoodCreatDto;
import com.fastfood.fastfood.dtos.food.FoodDto;
import com.fastfood.fastfood.dtos.food.FoodUpdateDto;
import com.fastfood.fastfood.projection.food.FoodProjection;
import com.fastfood.fastfood.services.base.GenericCrudService;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FoodService extends GenericCrudService<FoodDto, FoodCreatDto, FoodUpdateDto, String, GenericCriteria> {

    Page<FoodProjection> getAllByCategoryId(String categoryId, GenericCriteria criteria);

    Page<FoodProjection> getAllFoods(GenericCriteria criteria);
}
