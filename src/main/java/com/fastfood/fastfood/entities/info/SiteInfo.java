package com.fastfood.fastfood.entities.info;


import com.fastfood.fastfood.entities.base.BaseGenericEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "site_infos")
@Table(schema = "info")
public class SiteInfo implements BaseGenericEntity {

    @Id
    @GeneratedValue
    String id = UUID.randomUUID().toString();

    @Column(columnDefinition = "text")
    String address;

    String phoneNumber;

    double latitude;

    double longitude;

}
