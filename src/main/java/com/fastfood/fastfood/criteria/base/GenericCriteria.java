package com.fastfood.fastfood.criteria.base;

import lombok.*;
import org.springdoc.api.annotations.ParameterObject;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ParameterObject
public class GenericCriteria implements BaseGenericCriteria, Serializable {

    protected Integer page;

    protected Integer size;

    protected String sortBy;

    protected String sortDirection;

    public String getSortDirection() {
        return sortDirection == null || sortDirection.equals("") ? " ASC " : sortDirection;
    }

    public String getSortBy() {
        return sortBy == null || sortBy.equals("") ? "id":sortBy;
    }
}