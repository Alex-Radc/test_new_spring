package com.alexra.spring.test_new_spring.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity implements Serializable {
    @Id
    @Column(name = "Id")
    private Long id;

    @Column(name = "deleted", columnDefinition = "Bit(1) default false")
    private boolean deleted = false;

    @Column(name = "DataChange_CreatedBy", nullable = false)
    private String dataChangeCreatedBy;

    @Column(name = "DataChange_CreatedTime", nullable = false)
    private Date dataChangeCreatedTime;

    @Column(name = "DataChange_LastModifiedBy")
    private String dataChangeLastModifiedBy;

    @Column(name = "DataChange_LastTime")
    private Date dataChangeLastModifiedTime;

    @PrePersist
    protected void prePersist() {
        if (this.dataChangeCreatedTime == null) dataChangeCreatedTime = new Date();
        if (this.dataChangeLastModifiedTime == null) dataChangeLastModifiedTime = new Date();
    }

    @PreUpdate
    protected void preUpdate() {
        this.dataChangeLastModifiedTime = new Date();
    }

    @PreRemove
    protected void preRemove() {
        this.dataChangeLastModifiedTime = new Date();
    }
}