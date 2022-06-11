package com.fastfood.fastfood.services.food;

import com.fastfood.fastfood.criteria.base.GenericCriteria;
import com.fastfood.fastfood.dtos.food.FoodCreatDto;
import com.fastfood.fastfood.dtos.food.FoodDto;
import com.fastfood.fastfood.dtos.food.FoodUpdateDto;
import com.fastfood.fastfood.entities.foods.Category;
import com.fastfood.fastfood.entities.foods.Food;
import com.fastfood.fastfood.exceptions.food.CategoryNotFoundException;
import com.fastfood.fastfood.mappers.food.FoodMapper;
import com.fastfood.fastfood.projection.food.FoodProjection;
import com.fastfood.fastfood.repositories.food.CategoryRepository;
import com.fastfood.fastfood.repositories.food.FoodRepository;
import com.fastfood.fastfood.services.base.AbstractService;
import com.fastfood.fastfood.validators.base.BaseGenericValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
@Service
public class FoodServiceImpl extends AbstractService<FoodRepository, FoodMapper, BaseGenericValidator> implements FoodService {

    @PersistenceContext
    private EntityManager entityManager;

    private final CategoryRepository categoryRepository;

    protected FoodServiceImpl(FoodMapper mapper, BaseGenericValidator validator, FoodRepository repository, CategoryRepository categoryRepository) {
        super(mapper, validator, repository);
        this.categoryRepository = categoryRepository;
    }


    @Override
    public String create(FoodCreatDto dto) {
        Food food = mapper.fromCreateDto(dto);
        Optional<Category> byId = categoryRepository.findById(dto.getCategoryId());
        if (byId.isEmpty()) throw new CategoryNotFoundException("category not found in food service. Method create");
        food.setCategory(byId.get());
        repository.save(food);
        return food.getId();
    }

    @Override
    public void delete(String id) {
        repository.changeIsDelete(true, id);
    }

    @Override
    public void update(FoodUpdateDto dto) {
        Food food = mapper.fromUpdateDto(dto);
        Optional<Category> categoryOptional = categoryRepository.findById(dto.getCategoryId());
        if (categoryOptional.isEmpty()) throw new CategoryNotFoundException("Category not found in food service. Method update");
        food.setCategory(categoryOptional.get());
        repository.save(food);
    }

    @Override
    public FoodDto get(String id) {
        String lang = "uz";
        return repository.getFoodByIdToDto(id, lang);
    }
    @Override
    public List<FoodDto> getAll(GenericCriteria criteria) {
        return null;
    }

    @Override
    public Page<FoodProjection> getAllByCategoryId(String categoryId, GenericCriteria criteria) {
        String lang = "uz";
        return repository.getAllByCategoryId(categoryId, PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by(criteria.getSortDirection(), criteria.getSortBy())), lang);
    }

    @Override
    public Page<FoodProjection> getAllFoods(GenericCriteria criteria) {
        return repository.getAllFood(PageRequest.of(criteria.getPage(), criteria.getSize(), Sort.by(criteria.getSortDirection(), criteria.getSortBy())));

    }
}
