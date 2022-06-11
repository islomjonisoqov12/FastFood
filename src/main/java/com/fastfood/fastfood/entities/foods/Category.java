package com.fastfood.fastfood.entities.foods;

import com.fastfood.fastfood.entities.base.AbsNameEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "categories")
@Table(schema = "food")
public class Category extends AbsNameEntity {
    
    @Builder(builderMethodName = "childBuilder")
    public Category(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy, boolean deleted, short status, String nameUz, String nameRu, String nameOz, String nameEn, String descriptionUz, String descriptionRu, String descriptionOz, String descriptionEn) {
        super(id, createdAt, updatedAt, createdBy, updatedBy, deleted, status,nameUz,nameRu,nameOz,nameEn,descriptionUz,descriptionRu,descriptionOz,descriptionEn);
    }

}
