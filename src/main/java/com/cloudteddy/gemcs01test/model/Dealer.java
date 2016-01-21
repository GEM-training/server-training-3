package com.cloudteddy.gemcs01test.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kimtung on 1/18/16.
 * TODO: unresolved error: mapping failed to initialize lazy load, fetch type is now temporarily set to EAGER
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

    @OneToMany(mappedBy = "dealer", fetch = FetchType.EAGER)
    private Set<Inventory> inventories = new HashSet<>();

    @OneToMany(mappedBy = "dealer", fetch = FetchType.EAGER)
    private Set<Staff> staffs = new HashSet<>();

    @OneToMany(mappedBy = "dealer", fetch = FetchType.EAGER)
    private Set<Bill> bills = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "maker_dealer",
            joinColumns = {@JoinColumn(name = "dealer_id")},
            inverseJoinColumns = {@JoinColumn(name = "maker_id")}
    )
    private Set<Maker> makers;

    @OneToMany(mappedBy = "dealer", fetch = FetchType.EAGER)
    private Set<Promotion> promotions;

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

    public Set<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(Set<Inventory> inventories) {
        this.inventories = inventories;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }

    public Set<Maker> getMakers() {
        return makers;
    }

    public void setMakers(Set<Maker> makers) {
        this.makers = makers;
    }

    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }
}
