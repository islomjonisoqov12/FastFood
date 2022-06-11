package com.fastfood.fastfood.projection.food;

import com.fastfood.fastfood.projection.base.GenericProjection;

import java.time.LocalTime;

public interface FoodProjection extends GenericProjection {

    String getImage();

    LocalTime getAvailableFrom();

    LocalTime getAvailableTo();

    Integer getPreparationTimeInMin();

    Long getPrice();

}
