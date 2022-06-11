package com.fastfood.fastfood.dtos.food;

import com.fastfood.fastfood.dtos.base.BaseGenericDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryCreateDto implements BaseGenericDto {
    String nameUz;
    String nameRu;
    String nameOz;
    String nameEn;
    String descriptionUz;
    String descriptionRu;
    String descriptionOz;
    String descriptionEn;
    // TODO: 6/10/2022 validation
}
