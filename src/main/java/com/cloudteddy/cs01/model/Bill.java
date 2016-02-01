package com.cloudteddy.cs01.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kimtung on 1/20/16.
 */
@Entity
@Table(name = "bill")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "entity")
@Cacheable
public class Bill {

    @Id
    @SequenceGenerator(name = "bill_id_seq", sequenceName = "bill_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_id_seq")
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "dealer_id", referencedColumnName = "id")
    private Dealer dealer;

    @OneToMany(mappedBy = "id.bill", cascade = CascadeType.ALL)
    private Set<BillLine> billLines = new HashSet<>(0);

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Set<BillLine> getBillLines() {
        return billLines;
    }

    public void setBillLines(Set<BillLine> billLines) {
        this.billLines = billLines;
    }


    @Entity
    @Table(name = "bill_line")
    @AssociationOverrides({
            @AssociationOverride(name = "id.bill", joinColumns = @JoinColumn(name = "bill_id")),
            @AssociationOverride(name = "id.product", joinColumns = @JoinColumn(name = "product_id"))
    })
    public static class BillLine {

        @EmbeddedId
        private Id id;

        @Column(name = "quantity")
        private int quantity;

        @Column(name = "price")
        private double price;

        @Embeddable
        public static class Id implements Serializable {
            @ManyToOne
            private Bill bill;

            @ManyToOne
            private Product product;

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Id id = (Id) o;
                if (bill.getId() != id.bill.getId()) return false;
                return product.getId() == id.product.getId();

            }

            @Override
            public int hashCode() {
                int result = bill.hashCode();
                result = 31 * result + product.hashCode();
                return result;
            }

            public Bill getBill() {
                return bill;
            }

            public void setBill(Bill bill) {
                this.bill = bill;
            }

            public Product getProduct() {
                return product;
            }

            public void setProduct(Product product) {
                this.product = product;
            }
        }
    }
}