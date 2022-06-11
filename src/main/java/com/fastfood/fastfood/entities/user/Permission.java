package com.fastfood.fastfood.entities.user;


import com.fastfood.fastfood.entities.base.Auditable;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "permissions")
@Table(schema = "users")
public class Permission extends Auditable {

    @Column(unique = true, nullable = false)
    String name;



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_permissions",
            joinColumns = @JoinColumn(name = "permission_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    List<User> users = new ArrayList<>();
}



