package com.fastfood.fastfood.services.food;

import com.fastfood.fastfood.criteria.base.GenericCriteria;
import com.fastfood.fastfood.dtos.food.FoodCreatDto;
import com.fastfood.fastfood.dtos.food.FoodDto;
import com.fastfood.fastfood.dtos.food.FoodUpdateDto;
import com.fastfood.fastfood.entities.foods.Category;
import com.fastfood.fastfood.entities.foods.Food;
import com.fastfood.fastfood.exceptions.food.CategoryNotFoundException;
import com.fastfood.fastfood.exceptions.food.FoodNotFoundException;
import com.fastfood.fastfood.mappers.food.FoodMapper;
import com.fastfood.fastfood.projection.food.CategoryForFoodProjection;
import com.fastfood.fastfood.projection.food.FoodProjection;
import com.fastfood.fastfood.repositories.food.CategoryRepository;
import com.fastfood.fastfood.repositories.food.FoodRepository;
import com.fastfood.fastfood.services.base.AbstractService;
import com.fastfood.fastfood.validators.base.BaseGenericValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FoodServiceImpl extends AbstractService<FoodRepository, FoodMapper, BaseGenericValidator> implements FoodService {

    private final CategoryRepository categoryRepository;

    protected FoodServiceImpl(FoodMapper mapper, BaseGenericValidator validator, FoodRepository repository, CategoryRepository categoryRepository) {
        super(mapper, validator, repository);
        this.categoryRepository = categoryRepository;
    }


    @Override
    public String create(FoodCreatDto dto) {
        Food food = mapper.fromCreateDto(dto);
        Optional<Category> byId = categoryRepository.findByIdAndDeletedFalse(dto.getCategoryId());
        if (byId.isEmpty()) throw new CategoryNotFoundException("category not found in food service. Method create");
        food.setCategory(byId.get());
        repository.save(food);
        return food.getId();
    }

    @Override
    public void delete(String id) {
        repository.changeIsDelete(1, id);
    }

    @Override
    public void update(FoodUpdateDto dto) {
        Optional<Food> foodOptional = repository.findByIdAndDeletedFalse(dto.getId());
        if (foodOptional.isEmpty()) throw new FoodNotFoundException("food not found method update 53 food service");
        Food food = mapper.fromUpdateDto(dto, foodOptional.get());
        Optional<Category> categoryOptional = categoryRepository.findByIdAndDeletedFalse(dto.getCategoryId());
        if (categoryOptional.isEmpty()) throw new CategoryNotFoundException("Category not found in food service. Method update");
        food.setCategory(categoryOptional.get());
        repository.save(food);
    }

    @Override
    public FoodDto get(String id, String lang) {
        return repository.getFoodByIdToDto(id, lang);
    }
    @Override
    public List<FoodDto> getAll(GenericCriteria criteria, String lang) {
        return null;
    }

    @Override
    public Page<FoodProjection> getAllByCategoryId(String categoryId, GenericCriteria criteria, String lang) {
        return repository.getAllByCategoryId(categoryId, PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by(criteria.getSortDirection(), criteria.getSortBy())), lang);
    }

    @Override
    public Page<CategoryForFoodProjection> getAllFoods(GenericCriteria criteria, String lang) {
        return repository.getAllFood(PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by(criteria.getSortDirection(), criteria.getSortBy())), lang);

    }
}
