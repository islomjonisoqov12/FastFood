package com.fastfood.fastfood.dtos.food;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fastfood.fastfood.dtos.base.BaseGenericDto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
//    @DateTimeFormat(iso=DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern="HH:mm:ss")
    Time availableFrom;

//    @DateTimeFormat()
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
