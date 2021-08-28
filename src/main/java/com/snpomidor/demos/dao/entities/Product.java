package com.snpomidor.demos.dao.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "PRODUCTS")
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Product extends AbstractEntity {

    @Column
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private ProductCategory category;
}
