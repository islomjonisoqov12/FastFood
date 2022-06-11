package com.fastfood.fastfood.services.food;

import com.fastfood.fastfood.criteria.base.GenericCriteria;
import com.fastfood.fastfood.dtos.food.CategoryCreateDto;
import com.fastfood.fastfood.dtos.food.CategoryDto;
import com.fastfood.fastfood.dtos.food.CategoryUpdateDto;
import com.fastfood.fastfood.entities.foods.Category;
import com.fastfood.fastfood.mappers.food.CategoryMapper;
import com.fastfood.fastfood.repositories.food.CategoryRepository;
import com.fastfood.fastfood.services.base.AbstractService;
import com.fastfood.fastfood.validators.base.BaseGenericValidator;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl extends AbstractService<CategoryRepository, CategoryMapper, BaseGenericValidator> implements CategoryService {
    protected CategoryServiceImpl(CategoryMapper mapper, BaseGenericValidator validator, CategoryRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public String create(CategoryCreateDto dto) {
//        Category category = new Category();
        Category category = mapper.fromCreateDto(dto);
        repository.save(category);
        return category.getId();
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(CategoryUpdateDto dto) {

    }

    @Override
    public CategoryDto get(String id) {
        return null;
    }

    @Override
    public List<CategoryDto> getAll(GenericCriteria criteria) {
        return null;
    }
}
