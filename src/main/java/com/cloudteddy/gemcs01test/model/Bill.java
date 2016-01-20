package com.cloudteddy.gemcs01test.model;

import javax.persistence.*;

/**
 * Created by kimtung on 1/20/16.
 */
@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id", nullable = false)
    private long id;

    @Column(name = "customer_id", nullable = false)
    private long customerId;

    @ManyToOne
    @JoinColumn(name = "dealer_id", referencedColumnName = "dealer_id")
    private Dealer dealer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

}
