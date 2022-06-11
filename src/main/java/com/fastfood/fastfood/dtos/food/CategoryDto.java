package com.fastfood.fastfood.dtos.food;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fastfood.fastfood.dtos.base.GenericDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto extends GenericDto {
    String name;
    String description;

    public CategoryDto(@NotNull @NotEmpty @NotBlank String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }
    public CategoryDto(@NotNull @NotEmpty @NotBlank String id, String name) {
        super(id);
        this.name = name;
    }




}
