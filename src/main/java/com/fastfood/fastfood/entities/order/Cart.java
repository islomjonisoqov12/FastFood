package com.fastfood.fastfood.entities.order;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@RedisHash(value = "carts")

@TypeDefs({
        @TypeDef(name = "string-array", typeClass = StringArrayType.class),
        @TypeDef(name = "int-array", typeClass = IntArrayType.class),
        @TypeDef(name = "json", typeClass = JsonType.class)
})
public class Cart implements Serializable {

    @Id
    String id = UUID.randomUUID().toString();

    @Column(nullable = false, unique = true)
    String userId;

    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    Set<OrderItem> orderItems = new HashSet<>();

}
