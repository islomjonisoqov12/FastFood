package com.fastfood.fastfood.entities.user;


import com.fastfood.fastfood.entities.base.Auditable;
import com.fastfood.fastfood.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "users")
@Table(schema = "users")

@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends Auditable {

    @Column(nullable = false)
    String fullName;

    @Column(nullable = false, unique = true)
    String phoneNumber;

    @Enumerated(EnumType.STRING)
    Role role = Role.CUSTOMER;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_permissions",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    List<Permission> permissions = new ArrayList<>();




}
