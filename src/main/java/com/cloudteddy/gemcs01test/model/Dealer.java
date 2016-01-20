package com.cloudteddy.gemcs01test.model;

import javax.persistence.*;

/**
 * Created by kimtung on 1/18/16.
 */
@Entity
@Table(name = "dealer")
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dealer_id", nullable = false)
    private long id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "phone", nullable = true)
    private String phone;

    @Column(name = "address", nullable = true)
    private String address;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        } else if(obj == null) {
            return false;
        } else if(!(obj instanceof Dealer)) {
            return false;
        }
        Dealer dealer = (Dealer) obj;
        return this.id == dealer.id && this.name.equals(dealer.name) && this.address.equals(dealer.address) &&
                this.phone.equals(dealer.phone);
    }

    @Override
    public String toString() {
        return "[ id: " + this.id + ", name: " + this.name + ", phone: " + this.phone + ", address: " + this.address + " ]";
    }
}
