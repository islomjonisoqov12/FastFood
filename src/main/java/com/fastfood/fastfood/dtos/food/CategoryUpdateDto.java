package com.fastfood.fastfood.dtos.food;

import com.fastfood.fastfood.dtos.base.GenericDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryUpdateDto extends GenericDto {
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
