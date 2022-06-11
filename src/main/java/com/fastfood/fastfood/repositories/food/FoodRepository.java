package com.fastfood.fastfood.repositories.food;

import com.fastfood.fastfood.dtos.food.FoodDto;
import com.fastfood.fastfood.entities.foods.Food;
import com.fastfood.fastfood.projection.food.CategoryForFoodProjection;
import com.fastfood.fastfood.projection.food.FoodProjection;
import com.fastfood.fastfood.repositories.base.AbstractRepository;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@TypeDefs({
        @TypeDef(name = "string-array", typeClass = StringArrayType.class),
        @TypeDef(name = "int-array", typeClass = IntArrayType.class),
        @TypeDef(name = "json", typeClass = JsonType.class)
})
public interface FoodRepository extends AbstractRepository<Food, String> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update food.foods set is_deleted = :deleted where id=:foodId")
    void changeIsDelete(Number deleted, String foodId);

    @Query("""
            select new com.fastfood.fastfood.dtos.food.FoodDto(
            f.id,
            (case when :lang='uz' then f.nameUz when :lang='ru' then f.nameRu when :lang='oz' then f.nameOz else f.nameEn end),
            (case when :lang='uz' then f.descriptionUz when :lang='ru' then f.descriptionRu when :lang='oz' then f.descriptionOz else f.descriptionEn end),
            f.availableFrom,
            f.availableTo,
            f.imageLink,
            f.preparationTimeInMin,
            f.price
            ) from foods f
            join categories c on c.id = f.category
             where f.id = :id and f.deleted = false
            """
    )
    FoodDto getFoodByIdToDto(String id, String lang);

    @Query(nativeQuery = true, value = """
            select f.id as "id",
            case when :lang='uz' then f.name_uz when :lang= 'ru' then f.name_ru when :lang='oz' then f.name_oz else f.name_en end as "name",
            f.image_link as "image",
            f.available_from as "availableFrom",
            f.available_to as "availableTo",
            f.preparation_time_in_min as "preparationTimeInMin",
            f.price as "price"
            from food.foods f
            join food.categories c on f.category_id = c.id
            where c.id = :categoryId and c.is_deleted=0
            """)
    Page<FoodProjection> getAllByCategoryId(String categoryId, PageRequest of, String lang);

    @Query(nativeQuery = true, value = """
            select id,
                case when :lang='uz' then name_uz when :lang= 'ru' then name_ru when :lang='oz' then name_oz else name_en end as "name",
                :lang as lang
             from food.categories
             where is_deleted =0
            """)
    Page<CategoryForFoodProjection> getAllFood(PageRequest of, String lang);


    @Query(nativeQuery = true, value = """
            select f.id as "id",
                        case when :lang='uz' then f.name_uz when :lang= 'ru' then f.name_ru when :lang='oz' then f.name_oz else f.name_en end as "name",
                        f.image_link as "image",
                        f.available_from as "availableFrom",
                        f.available_to as "availableTo",
                        f.preparation_time_in_min as "preparationTimeInMin",
                        f.price as "price"
                         from food.foods f
                         where is_deleted = 0 and f.category_id = :categoryId
            """)
    List<FoodProjection> getFoodByCategoryId(String categoryId, String lang);

    Optional<Food> findByIdAndDeletedFalse(String id);
}
