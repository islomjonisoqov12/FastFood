package com.fastfood.fastfood.projection.food;

import com.fastfood.fastfood.projection.base.GenericProjection;
import org.springframework.beans.factory.annotation.Value;


import java.util.List;

public interface CategoryForFoodProjection extends GenericProjection {

    @Value(value = "#{@foodRepository.getFoodByCategoryId(target.id, target.lang)}")
    List<FoodProjection> getFoods();
    // TODO: 6/10/2022 write methods
}
