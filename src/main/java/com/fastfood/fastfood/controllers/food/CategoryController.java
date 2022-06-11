package com.fastfood.fastfood.controllers.food;

import com.fastfood.fastfood.controllers.AbstractController;
import com.fastfood.fastfood.criteria.base.GenericCriteria;
import com.fastfood.fastfood.dtos.food.CategoryCreateDto;
import com.fastfood.fastfood.dtos.food.CategoryDto;
import com.fastfood.fastfood.dtos.food.CategoryUpdateDto;
import com.fastfood.fastfood.payload.ApiResponse;
import com.fastfood.fastfood.services.food.CategoryService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CategoryController extends AbstractController<CategoryService> {
    protected CategoryController(CategoryService service) {
        super(service);
    }

    @PostMapping(PATH+"/category")
    public HttpEntity<ApiResponse<String>> saveCategory(@RequestBody CategoryCreateDto categoryCreateDto){
        service.create(categoryCreateDto);
        return ResponseEntity.ok(ApiResponse.<String>builder().success(true).build());
    }

    @PutMapping(PATH+"/category")
    public HttpEntity<ApiResponse<String>> updateCategory(@RequestBody CategoryUpdateDto categoryUpdateDto){
        service.update(categoryUpdateDto);
        return ResponseEntity.ok(ApiResponse.<String>builder().success(true).build());
    }

    @GetMapping(PATH+"/category/{id}")
    public HttpEntity<CategoryDto> getById(@RequestHeader String lang, @PathVariable String id){
        CategoryDto categoryDto = service.get(id, lang);
        return ResponseEntity.ok(categoryDto);
    }

    @GetMapping(PATH+"/category-all")
    public HttpEntity<List<CategoryDto>> getAll(@RequestHeader String lang, GenericCriteria genericCriteria){
        List<CategoryDto> all = service.getAll(genericCriteria, lang);
        return ResponseEntity.ok(all);
    }

    @DeleteMapping(PATH+"/category/{id}")
    public HttpEntity<ApiResponse<String>> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.<String>builder().success(true).build());
    }
}
