package com.cloudteddy.gemcs01test.model;

import javax.persistence.*;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "dealer_id", referencedColumnName = "dealer_id")
    private Dealer dealer;

    @OneToMany(mappedBy = "bill")
    private Set<BillLine> billLines;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Entity
    @Table(name = "bill_line")
    public static class BillLine {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "bill_line_id")
        private long id;

        @ManyToOne
        @JoinColumn(name = "bill_id", referencedColumnName = "bill_id")
        private Bill bill;

        @Column(name = "product_id")
        private long productId;

        @Column(name = "quantity")
        private int quantity;

        @Column(name = "price")
        private double price;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public Bill getBill() {
            return bill;
        }

        public void setBill(Bill bill) {
            this.bill = bill;
        }

        public long getProductId() {
            return productId;
        }

        public void setProductId(long productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}