package com.cloudteddy.gemcs01test.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by kimtung on 1/20/16.
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "product_type", referencedColumnName = "product_type_id")
    private Type type;

    @Column(name = "detail", nullable = false)
    private String detail;

    @OneToMany(mappedBy = "id.product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Bill.BillLine> billLines;

    @OneToMany(mappedBy = "id.product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Inventory.ProductInInventory> inventories;

    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
    private Set<Promotion> promotions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Set<Bill.BillLine> getBillLines() {
        return billLines;
    }

    public void setBillLines(Set<Bill.BillLine> billLines) {
        this.billLines = billLines;
    }

    public Set<Inventory.ProductInInventory> getInventories() {
        return inventories;
    }

    public void setInventories(Set<Inventory.ProductInInventory> inventories) {
        this.inventories = inventories;
    }

    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }

    @Entity
    @Table(name = "product_type")
    public static class Type {

        @Id
        @Column(name = "product_type_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "name")
        private String name;

        @OneToMany(mappedBy = "type", fetch = FetchType.EAGER)
        private Set<Product> products;
    }
}
