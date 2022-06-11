package com.fastfood.fastfood.entities.base;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable implements BaseGenericEntity {
    @Id
    @Column(unique = true)
    private String id = UUID.randomUUID().toString();

    @CreatedDate
    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "timestamp default now()")
    private LocalDateTime createdAt = LocalDateTime.now();

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @CreatedBy
    @Column(name = "created_by_id", columnDefinition = "varchar")
    private String createdBy;

    @LastModifiedBy
    @Column(name = "updated_by_id", columnDefinition = "varchar")
    private String updatedBy;

    @Column(name = "is_deleted", columnDefinition = "NUMERIC default 0")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean deleted;

    private short status;

    public Auditable(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy, boolean deleted, short status) {
        this.id = id==null? UUID.randomUUID().toString():id;
        this.createdAt = createdAt==null? LocalDateTime.now():createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.deleted = deleted;
        this.status = status;
    }
}
