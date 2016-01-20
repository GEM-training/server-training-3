package com.cloudteddy.gemcs01test.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kimtung on 1/20/16.
 */
@Entity
@Table(name = "promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_id", nullable = false)
    private long id;

    @Column(name = "dealer_id", nullable = false)
    private long dealerId;

    @Column(name = "start_time", nullable = false)
    private Date startTime;

    @Column(name = "end_time", nullable = false)
    private Date endTime;

    @Column(name = "detail", nullable = true)
    private String detail;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDealerId() {
        return dealerId;
    }

    public void setDealerId(long dealerId) {
        this.dealerId = dealerId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promotion promotion = (Promotion) o;

        if (id != promotion.id) return false;
        if (dealerId != promotion.dealerId) return false;
        if (startTime != null ? !startTime.equals(promotion.startTime) : promotion.startTime != null) return false;
        if (endTime != null ? !endTime.equals(promotion.endTime) : promotion.endTime != null) return false;
        return detail != null ? detail.equals(promotion.detail) : promotion.detail == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (dealerId ^ (dealerId >>> 32));
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", dealerId=" + dealerId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", detail='" + detail + '\'' +
                '}';
    }
}
