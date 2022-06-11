package com.fastfood.fastfood.dtos.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GenericDto implements BaseGenericDto {
    @NotNull @NotEmpty @NotBlank
    private String id;
}
