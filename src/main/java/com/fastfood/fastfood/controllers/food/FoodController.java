package com.fastfood.fastfood.controllers.food;

import com.fastfood.fastfood.controllers.AbstractController;
import com.fastfood.fastfood.criteria.base.GenericCriteria;
import com.fastfood.fastfood.dtos.food.FoodCreatDto;
import com.fastfood.fastfood.dtos.food.FoodDto;
import com.fastfood.fastfood.dtos.food.FoodUpdateDto;
import com.fastfood.fastfood.payload.ApiResponse;
import com.fastfood.fastfood.projection.food.CategoryForFoodProjection;
import com.fastfood.fastfood.projection.food.FoodProjection;
import com.fastfood.fastfood.services.food.FoodService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public HttpEntity<ApiResponse<FoodDto>> getFood(@RequestHeader String lang, @RequestParam String id){
        FoodDto foodDto = service.get(id, lang);
        return ResponseEntity.ok(new ApiResponse<>("success",foodDto, true));
    }

    @GetMapping(PATH+"/food-all")
    public HttpEntity<ApiResponse<Page<CategoryForFoodProjection>>> getAll(@RequestHeader String lang, GenericCriteria criteria){
        Page<CategoryForFoodProjection> all = service.getAllFoods(criteria, lang);
        return ResponseEntity.ok(new ApiResponse<>("success", all, true));
    }

    @GetMapping(PATH+"/food/{categoryId}")
    public HttpEntity<ApiResponse<Page<FoodProjection>>> getAll(@RequestHeader String lang, GenericCriteria criteria, @PathVariable String categoryId){
        Page<FoodProjection> allByCategoryId = service.getAllByCategoryId(categoryId,criteria, lang);
        return ResponseEntity.ok(new ApiResponse<>("success", allByCategoryId, true));
    }

    @DeleteMapping(PATH+"/food/{id}")
    public HttpEntity<ApiResponse<String>> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.<String>builder().success(true).build());
    }


}
