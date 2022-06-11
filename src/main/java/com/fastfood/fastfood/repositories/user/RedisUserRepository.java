package com.fastfood.fastfood.repositories.user;

import com.fastfood.fastfood.entities.user.RedisUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisUserRepository extends CrudRepository<RedisUser, String> {
}
