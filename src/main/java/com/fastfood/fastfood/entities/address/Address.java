package com.fastfood.fastfood.entities.address;

import com.fastfood.fastfood.entities.base.Auditable;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "addresses")
@Table(schema = "address")
public class Address extends Auditable {

    String name;

    @Column(nullable = false)
    String districtName;

    String landMark;

    Integer houseNumber;

    Integer entrance;

    int flat;

    int floor;

    @Column(nullable = false)
    Double latitude;

    @Column(nullable = false)
    Double longitude;


}
