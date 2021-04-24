package com.springboot.prices.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PRICE")
public class Price {

    @Id
    @Column
    @GeneratedValue
    private int id;

    @ManyToOne()
    @JoinColumn(name = "BRAND_ID")
    private Brand brandId;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "PRICE_LIST")
    private int priceList;

    @Column(name = "PRODUCT_ID")
    private int productId;

    @Column
    private int priority;

    @Column
    private long price;

    @Column(name = "CURR", length = 3)
    private String currency;
}
