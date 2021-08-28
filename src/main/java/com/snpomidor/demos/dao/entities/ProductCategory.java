package com.snpomidor.demos.dao.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Список категорий товара. Имеет иерархическую структуру.
 */
@Entity
@Table(name = "PRODUCT_CATEGORY")
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductCategory extends AbstractEntity {

    /**
     * Название категории.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Родительская категория.
     */
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private ProductCategory parent;
}
