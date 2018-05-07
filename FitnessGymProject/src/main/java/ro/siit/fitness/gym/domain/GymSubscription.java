package ro.siit.fitness.gym.domain;

import java.util.Date;

public class GymSubscription {
    private String type;
    private float price;
    private float discount;
    private Date startDate;
    private Date endDate;
    private long id;

    public GymSubscription() {
    }


    public GymSubscription(String type, float price, float discount, Date startDate, Date endDate, long id) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
