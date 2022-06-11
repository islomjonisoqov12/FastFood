package com.fastfood.fastfood.repositories.food;

import com.fastfood.fastfood.dtos.food.CategoryDto;
import com.fastfood.fastfood.entities.foods.Category;
import com.fastfood.fastfood.repositories.base.AbstractRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends AbstractRepository<Category, String> {
    Optional<Category> findByIdAndDeletedFalse(String id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = """
            update food.categories set is_deleted = :deleted where id=:categoryId
            """)
    void changeIsDelete(String categoryId, Number deleted);

    @Query(value = """
            select new com.fastfood.fastfood.dtos.food.CategoryDto(
            id,
            (case when :lang='uz' then nameUz when :lang='ru' then nameRu when :lang='oz' then nameOz else nameEn end),
            (case when :lang='uz' then descriptionUz when :lang='ru' then descriptionRu when :lang='oz' then descriptionOz else descriptionEn end)
            ) from categories where deleted = false and id=:id
            """)
    Optional<CategoryDto> getCategory(String id, String lang);


    @Query(value = """
            select new com.fastfood.fastfood.dtos.food.CategoryDto(
            id,
            (case when :lang='uz' then nameUz when :lang='ru' then nameRu when :lang='oz' then nameOz else nameEn end)
            ) from categories where deleted = false
            """)
    List<CategoryDto> getAll(Pageable pageable, String lang);
}
