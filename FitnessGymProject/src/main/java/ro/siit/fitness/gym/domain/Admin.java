package ro.siit.fitness.gym.domain;

import java.util.Date;

public class Admin {
    SubscriptionCard subscriptionCard;
    GymSubscription gymSubscription;
    GymMember member;
    GymTrainer trainer;

    public Admin(SubscriptionCard subscriptionCard,
                 GymSubscription gymSubscription,
                 GymMember member,
                 GymTrainer trainer) {
        this.subscriptionCard = subscriptionCard;
        this.gymSubscription = gymSubscription;
        this.member = member;
        this.trainer = trainer;
    }

    public Admin() {
    }

    public SubscriptionCard getSubscriptionCard() {
        return subscriptionCard;
    }

    public void setSubscriptionCard(SubscriptionCard subscriptionCard) {
        this.subscriptionCard = subscriptionCard;
    }

    public GymSubscription getGymSubscription() {
        return gymSubscription;
    }

    public void setGymSubscription(GymSubscription gymSubscription) {
        this.gymSubscription = gymSubscription;
    }

    public GymMember getMember() {
        return member;
    }

    public void setMember(GymMember member) {
        this.member = member;
    }

    public GymTrainer getTrainer() {
        return trainer;
    }

    public void setTrainer(GymTrainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "subscriptionCard=" + subscriptionCard +
                ", gymSubscription=" + gymSubscription +
                ", member=" + member +
                ", trainer=" + trainer +
                '}';
    }


}
