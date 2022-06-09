package com.fastfood.fastfood.controllers;

import com.fastfood.fastfood.criteria.base.GenericCriteria;
import com.fastfood.fastfood.dtos.food.FoodCreatDto;
import com.fastfood.fastfood.dtos.food.FoodDto;
import com.fastfood.fastfood.dtos.food.FoodUpdateDto;
import com.fastfood.fastfood.payload.ApiResponse;
import com.fastfood.fastfood.services.food.FoodService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public class FoodController extends AbstractController<FoodService>{

    protected FoodController(FoodService service) {
        super(service);
    }

    @PostMapping(PATH+"/food")
    public HttpEntity<ApiResponse<String>> save(FoodCreatDto foodCreatDto){
        service.create(foodCreatDto);
        return ResponseEntity.ok(new ApiResponse<String>("success", null, true));
    }

    @PutMapping(PATH+"/food")
    public HttpEntity<ApiResponse<String>> update(FoodUpdateDto foodUpdateDto){
        service.update(foodUpdateDto);
        return ResponseEntity.ok(new ApiResponse<String>("success", null, true));
    }

    @GetMapping(PATH+"/food/{id}")
    public HttpEntity<ApiResponse<FoodDto>> getFood(@PathVariable String id){
        FoodDto foodDto = service.get(id);
        return ResponseEntity.ok(new ApiResponse<FoodDto>("success",foodDto, true));
    }

    @GetMapping(PATH+"/food-all")
    public HttpEntity<ApiResponse<List<FoodDto>>> getAll(GenericCriteria criteria){
        List<FoodDto> all = service.getAll(criteria);
        return ResponseEntity.ok(new ApiResponse<>("success", all, true));
    }

    @GetMapping(PATH+"/food/{categoryId}")
    public HttpEntity<ApiResponse<List<FoodDto>>> getAll(@PathVariable String categoryId){
        List<FoodDto> allByCategoryId = service.getAllByCategoryId(categoryId);
        return ResponseEntity.ok(new ApiResponse<>("success", allByCategoryId, true));
    }
}
