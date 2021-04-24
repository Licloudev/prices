package com.springboot.prices.model;

import javax.persistence.*;

@Entity
@Table(name = "BRAND")
public class Brand {

    @Id
    @Column
    @GeneratedValue
    private int id;

    @Column
    private String name;
}
