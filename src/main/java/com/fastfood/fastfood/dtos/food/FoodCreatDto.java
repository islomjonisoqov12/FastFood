package com.fastfood.fastfood.dtos.food;

import com.fastfood.fastfood.dtos.base.BaseGenericDto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FoodCreatDto implements BaseGenericDto {

    // TODO: 6/9/2022 validate
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


}
