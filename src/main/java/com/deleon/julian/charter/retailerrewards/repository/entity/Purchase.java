package com.deleon.julian.charter.retailerrewards.repository.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @Column
    private Integer id;

    @Column
    private String userId;

    @Column
    private Integer dollars;

    @Column
    private Date createdAt;

    public Integer getId() {
        return id;
    }

    public Purchase setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getDollars() {
        return dollars;
    }

    public Purchase setDollars(Integer dollars) {
        this.dollars = dollars;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Purchase setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Purchase setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}
