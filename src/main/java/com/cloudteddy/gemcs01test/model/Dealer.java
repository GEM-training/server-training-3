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
    @SequenceGenerator(name = "dealer_id_seq", sequenceName = "dealer_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dealer_id_seq")
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "name", nullable = false)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dealer dealer = (Dealer) o;

        if (id != dealer.id) return false;
        if (name != null ? !name.equals(dealer.name) : dealer.name != null) return false;
        if (phone != null ? !phone.equals(dealer.phone) : dealer.phone != null) return false;
        return address != null ? address.equals(dealer.address) : dealer.address == null;

    }
}
