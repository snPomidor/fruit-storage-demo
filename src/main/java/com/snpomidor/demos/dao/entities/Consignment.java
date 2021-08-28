package com.snpomidor.demos.dao.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Партия товара.
 */
@Entity
@Table(name = "CONSIGNMENTS")
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Consignment extends AbstractEntity {

    /**
     * Привязка к конкретной поставке товара.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "DELIVERY_ID", nullable = false)
    private Delivery delivery;

    /**
     * Товар.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    /**
     * Количество товара (вес в кг.)
     */
    @Column(columnDefinition = "NUMBER", scale = 3)
    private Double weight;

    /**
     * Стоимость товара за 1 кг.
     */
    @Transient
    private Price price;
}
