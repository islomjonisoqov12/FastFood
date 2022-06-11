package com.fastfood.fastfood.controllers.food;

import com.fastfood.fastfood.controllers.AbstractController;
import com.fastfood.fastfood.criteria.base.GenericCriteria;
import com.fastfood.fastfood.dtos.food.FoodCreatDto;
import com.fastfood.fastfood.dtos.food.FoodDto;
import com.fastfood.fastfood.dtos.food.FoodUpdateDto;
import com.fastfood.fastfood.payload.ApiResponse;
import com.fastfood.fastfood.projection.food.FoodProjection;
import com.fastfood.fastfood.services.food.FoodService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class FoodController extends AbstractController<FoodService> {

    protected FoodController(FoodService service) {
        super(service);
    }

    @PostMapping(PATH+"/food")
    public HttpEntity<ApiResponse<String>> save(@RequestBody FoodCreatDto foodCreatDto){
        service.create(foodCreatDto);
        return ResponseEntity.ok(new ApiResponse<>("success", null, true));
    }

    @PutMapping(PATH+"/food")
    public HttpEntity<ApiResponse<String>> update(@RequestBody FoodUpdateDto foodUpdateDto){
        service.update(foodUpdateDto);
        return ResponseEntity.ok(new ApiResponse<>("success", null, true));
    }

    @GetMapping(PATH+"/food")
    public HttpEntity<ApiResponse<FoodDto>> getFood(@RequestParam String id){
        FoodDto foodDto = service.get(id);
        return ResponseEntity.ok(new ApiResponse<>("success",foodDto, true));
    }

    @GetMapping(PATH+"/food-all")
    public HttpEntity<ApiResponse<Page<FoodProjection>>> getAll(@RequestParam(required = false) GenericCriteria criteria){
        Page<FoodProjection> all = service.getAllFoods(criteria);
        return ResponseEntity.ok(new ApiResponse<>("success", all, true));
    }

    @GetMapping(PATH+"/food/{categoryId}")
    public HttpEntity<ApiResponse<Page<FoodProjection>>> getAll(GenericCriteria criteria, @PathVariable String categoryId){
        Page<FoodProjection> allByCategoryId = service.getAllByCategoryId(categoryId,criteria);
        return ResponseEntity.ok(new ApiResponse<>("success", allByCategoryId, true));
    }


}
