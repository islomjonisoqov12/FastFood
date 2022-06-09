package com.fastfood.fastfood.repositories.order;

import com.fastfood.fastfood.entities.order.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, String> {
}
