package ro.siit.fitness.gym.domain;

public class GymSubscription {
    private String type;
    private int price;
    private float discount;

    public GymSubscription() {
    }


    public GymSubscription(String type, int price, float discount) {
        this.type = type;
        this.price = price;
        this.discount = discount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
