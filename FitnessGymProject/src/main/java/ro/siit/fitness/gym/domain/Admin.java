package ro.siit.fitness.gym.domain;

import java.util.LinkedList;
import java.util.List;

public class Admin {
    private SubscriptionCard subscriptionCard;
    private GymSubscription gymSubscription;
    private GymMember member;
    private GymTrainer trainer;
    private List<String> roles = new LinkedList<>();
    private String userName;

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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
