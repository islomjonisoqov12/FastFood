package com.fastfood.fastfood.projection.food;

import java.util.List;

public interface CategoryForFoodProjection {

    String getId();

    String getName();


    List<FoodProjection> getFoods();
    // TODO: 6/10/2022 write methods
}
