package com.snpomidor.demos.dao.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Периодические цены на товары.
 */
@Entity
@Table(name = "PRICES")
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Price extends AbstractEntity {

    /**
     * Поставщик, установивший цену.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "CONTRACTOR_ID", nullable = false)
    private Contractor contractor;

    /**
     * Продукт.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    /**
     * Значение цены.
     */
    @Column
    private Double value;

    /**
     * Дата начала актуальности цен.
     */
    @Column(name = "DATE_FROM")
    private Date dateFrom;

    /**
     * Дата завершения актуальности цены.
     */
    @Column(name = "DATE_TO")
    private Date dateTo;
}
