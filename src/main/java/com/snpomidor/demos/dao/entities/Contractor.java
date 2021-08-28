package com.snpomidor.demos.dao.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Set;

/**
 * Список поставщиков.
 */
@Entity
@Table(name = "CONTRACTORS")
@Setter @Getter
@EqualsAndHashCode(exclude = {"products"}, callSuper = true)
@ToString(callSuper = true)
public class Contractor extends AbstractEntity {

    /**
     * Название поставщика.
     */
    @Column
    private String name;

    /**
     * ИНН поставщика.
     */
    @Column
    private String inn;

    /**
     * Фактический адресс поставщика.
     */
    @Column
    private String address;

    /**
     * Электронная почта для связи.
     */
    @Column
    private String email;

    /**
     * Телефон для связи.
     */
    @Column
    private String phone;

    /**
     * Дополнительная информация.
     */
    @Column
    private String description;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "CONTRACTOR_PRODUCT",
            joinColumns = { @JoinColumn(name = "CONTRACTOR_ID") },
            inverseJoinColumns = { @JoinColumn(name = "PRODUCT_ID") }
    )
    private Set<Product> products;
}
