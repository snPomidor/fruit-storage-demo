package com.snpomidor.demos.dao.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Set;

/**
 * Поставка товара.
 */
@Entity
@Table(name = "DELIVERIES")
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Delivery extends AbstractEntity {

    /**
     * Поставщик.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "CONTRACTOR_ID", nullable = false)
    private Contractor contractor;

    /**
     * Дата поставки (планируемая).
     */
    @Column(name = "DELIVERY_DATE_PLAN")
    private Date datePlan;

    /**
     * Дата поставки (фактическая).
     */
    @Column(name = "DELIVERY_DATE_FACT")
    private Date dateFact;

    /**
     * Общий вес поставленной продукции (кг.).
     */
    @Column(name = "TOTAL_WEIGHT", scale = 3)
    private Double totalWeight;

    /**
     * Общая стоимость продукции в поставке.
     */
    @Column(name = "TOTAL_COST", columnDefinition = "NUMBER",scale = 2)
    private Double totalCost;

    /**
     * Признак того, что поставка прошла приёмку.
     */
    @Column(nullable = false)
    private boolean accepted;

    /**
     * Дата приемки (фактическая).
     */
    @Column(name = "ACCEPTED_DATE")
    private Date acceptedDate;

    /**
     * Комментарий к поставке.
     */
    @Column
    private String comment;

    /**
     * Список продукции в поставке.
     */
    @OneToMany(mappedBy="delivery")
    private Set<Consignment> consignments;
}
