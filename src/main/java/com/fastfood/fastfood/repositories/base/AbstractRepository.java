package com.fastfood.fastfood.repositories.base;

import com.fastfood.fastfood.entities.base.BaseGenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface AbstractRepository<
        E extends BaseGenericEntity,
        K extends Serializable
        > extends BaseGenericRepository, JpaRepository<E,K> {

}
