package com.fastfood.fastfood.entities.base;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class AbsNameEntity extends Auditable{

    @Column(nullable = false)
    String nameUz;
    @Column(nullable = false)
    String nameRu;
    @Column(nullable = false)
    String nameOz;
    @Column(nullable = false)
    String nameEn;

    @Column(nullable = false)
    String descriptionUz;
    @Column(nullable = false)
    String descriptionRu;
    @Column(nullable = false)
    String descriptionOz;
    @Column(nullable = false)
    String descriptionEn;

    public AbsNameEntity(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy, boolean deleted, short status, String nameUz, String nameRu, String nameOz, String nameEn, String descriptionUz, String descriptionRu, String descriptionOz, String descriptionEn) {
        super(id, createdAt, updatedAt, createdBy, updatedBy, deleted, status);
        this.nameUz = nameUz;
        this.nameRu = nameRu;
        this.nameOz = nameOz;
        this.nameEn = nameEn;
        this.descriptionUz = descriptionUz;
        this.descriptionRu = descriptionRu;
        this.descriptionOz = descriptionOz;
        this.descriptionEn = descriptionEn;
    }

}
