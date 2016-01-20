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

    @OneToMany(mappedBy = "dealer", fetch=FetchType.EAGER)
    private Set<Inventory> inventories = new HashSet<>();

    @OneToMany(mappedBy = "dealer", fetch = FetchType.EAGER)
    private Set<Staff> staffs = new HashSet<>();

    @OneToMany(mappedBy = "dealer", fetch = FetchType.EAGER)
    private Set<Bill> bills = new HashSet<>();

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

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", inventories=" + inventories +
                ", staffs=" + staffs +
                '}';
    }
}
