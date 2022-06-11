package com.fastfood.fastfood.services.food;

import com.fastfood.fastfood.criteria.base.GenericCriteria;
import com.fastfood.fastfood.dtos.food.CategoryCreateDto;
import com.fastfood.fastfood.dtos.food.CategoryDto;
import com.fastfood.fastfood.dtos.food.CategoryUpdateDto;
import com.fastfood.fastfood.entities.foods.Category;
import com.fastfood.fastfood.exceptions.food.CategoryNotFoundException;
import com.fastfood.fastfood.mappers.food.CategoryMapper;
import com.fastfood.fastfood.repositories.food.CategoryRepository;
import com.fastfood.fastfood.services.base.AbstractService;
import com.fastfood.fastfood.validators.base.BaseGenericValidator;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl extends AbstractService<CategoryRepository, CategoryMapper, BaseGenericValidator> implements CategoryService {
    protected CategoryServiceImpl(CategoryMapper mapper, BaseGenericValidator validator, CategoryRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public String create(CategoryCreateDto dto) {
        Category category = mapper.fromCreateDto(dto);
        repository.save(category);
        return category.getId();
    }

    @Override
    public void delete(String id) {
        repository.changeIsDelete(id, 1);
    }

    @Override
    public void update(CategoryUpdateDto dto) {
        Optional<Category> byId = repository.findByIdAndDeletedFalse(dto.getId());
        if (byId.isEmpty()) throw  new CategoryNotFoundException("category not found method update 40");
        Category category = mapper.fromUpdateDto(dto, byId.get());
        repository.save(category);

    }

    @Override
    public CategoryDto get(String id,String lang) {
        Optional<CategoryDto> category = repository.getCategory(id, lang);
        if (category.isEmpty()) return null;
        return category.get();
    }

    @Override
    public List<CategoryDto> getAll(GenericCriteria criteria, String lang) {
        return repository.getAll(criteria.getPageable(), lang);
    }
}
