package com.cloudteddy.gemcs01test.model;

import javax.persistence.*;

/**
 * Created by kimtung on 1/20/16.
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "detail", nullable = false)
    private String detail;

    @Column(name = "product_type", nullable = false)
    private int type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        } else if (obj == null ) {
            return false;
        } else if(!(obj instanceof Product)) {
            return false;
        }
        Product product = (Product) obj;
        return this.id == product.id &&
                this.name.equals(product.name) &&
                this.detail.equals(product.detail) &&
                this.type == product.type;
    }

    @Override
    public String toString() {
        return "[ id: " + this.id + ", name: " + this.name + ", detail: " + this.detail + ", type: " + this.type + " ]";
    }
}
