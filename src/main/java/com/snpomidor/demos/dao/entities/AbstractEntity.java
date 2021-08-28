package com.snpomidor.demos.dao.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class AbstractEntity implements Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

}
