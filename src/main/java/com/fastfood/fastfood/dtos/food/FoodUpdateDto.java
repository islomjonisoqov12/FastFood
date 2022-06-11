package com.fastfood.fastfood.dtos.food;

import com.fastfood.fastfood.dtos.base.GenericDto;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FoodUpdateDto extends GenericDto {
    // TODO: 6/9/2022 fields
    @NotNull
    String nameUz;
    String nameRu;
    String nameOz;
    String nameEn;
    String descriptionUz;
    String descriptionRu;
    String descriptionOz;
    String descriptionEn;
    Long price;
    String imageLink;
    @DateTimeFormat(iso=DateTimeFormat.ISO.TIME)
    LocalTime availableFrom;
    @DateTimeFormat(iso=DateTimeFormat.ISO.TIME)
    LocalTime availableTo;
    Integer preparationTimeInMin;
    String categoryId;
}
