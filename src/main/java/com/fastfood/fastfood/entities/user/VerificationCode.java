package com.fastfood.fastfood.entities.user;

import com.fastfood.fastfood.entities.base.BaseGenericEntity;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@RedisHash(value="VerificationCode")
public class VerificationCode implements Serializable {

    @Id
    String id;

    String phoneNumber;

    String code;

    LocalDateTime createdAt;

    LocalDateTime expiredAt;

}
