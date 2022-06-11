package com.fastfood.fastfood.entities.user;

import com.fastfood.fastfood.enums.Role;
import org.springframework.data.redis.core.RedisHash;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@RedisHash(value = "redis_redis")
public class RedisUser implements Serializable {

    @Id
    String id;

    String phoneNumber;

    Role role = Role.CUSTOMER;

    List<Permission> permissions = new ArrayList<>();

}
