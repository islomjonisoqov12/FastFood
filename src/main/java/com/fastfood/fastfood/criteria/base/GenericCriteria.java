package com.fastfood.fastfood.criteria.base;

import lombok.*;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

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

    public Sort.Direction getSortDirection() {
        return sortDirection == null || sortDirection.equals("") || sortDirection.equals("ASC")? Sort.Direction.ASC : Sort.Direction.DESC;
    }

    public String getSortBy() {
        return sortBy == null || sortBy.equals("") ? "id" :sortBy;
    }

    public Integer getPage() {
        return page==null || page ==0 ?1:page;
    }

    public Integer getSize() {
        return size==null || size<1? 15: size;
    }
}