package com.fastfood.fastfood.services.food;

import com.fastfood.fastfood.criteria.base.GenericCriteria;
import com.fastfood.fastfood.dtos.food.FoodCreatDto;
import com.fastfood.fastfood.dtos.food.FoodDto;
import com.fastfood.fastfood.dtos.food.FoodUpdateDto;

import java.util.List;

public class FoodServiceImpl implements FoodService {
    @Override
    public String create(FoodCreatDto dto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(FoodUpdateDto dto) {

    }

    @Override
    public FoodDto get(String id) {
        return null;
    }
    @Override
    public List<FoodDto> getAll(GenericCriteria criteria) {
        return null;
    }

    @Override
    public List<FoodDto> getAllByCategoryId(String categoryId) {
        return null;
    }
}
