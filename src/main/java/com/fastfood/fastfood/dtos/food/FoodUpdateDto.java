package com.fastfood.fastfood.dtos.food;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fastfood.fastfood.dtos.base.GenericDto;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.time.LocalTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FoodUpdateDto extends GenericDto {
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
    @JsonFormat(pattern="HH:mm:ss")
    Time availableFrom;
    @JsonFormat(pattern="HH:mm:ss")
    Time availableTo;
    Integer preparationTimeInMin;
    String categoryId;

    public LocalTime getAvailableFrom() {
        return availableFrom == null ? null :availableFrom.toLocalTime();
    }

    public LocalTime getAvailableTo() {
        return availableTo==null? null : availableTo.toLocalTime();
    }
}
