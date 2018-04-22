package ro.siit.fitness.gym.domain;

import java.util.LinkedList;
import java.util.List;

public class Admin {
    private SubscriptionCard subscriptionCard;
    private long subscriptionCardID;
    private GymSubscription gymSubscription;
    private long gymSubscriptionID;
    private GymMember gymMember;
    private long gymMemberID;
    private GymTrainer gymTrainer;
    private long gymTrainerID;
    private List<String> roles = new LinkedList<>();
    private String userName;

    public Admin(SubscriptionCard subscriptionCard, long subscriptionCardID, GymSubscription gymSubscription, long gymSubscriptionID, GymMember gymMember, long gymMemberID, GymTrainer gymTrainer, long gymTrainerID, List<String> roles, String userName) {
        this.subscriptionCard = subscriptionCard;
        this.subscriptionCardID = subscriptionCardID;
        this.gymSubscription = gymSubscription;
        this.gymSubscriptionID = gymSubscriptionID;
        this.gymMember = gymMember;
        this.gymMemberID = gymMemberID;
        this.gymTrainer = gymTrainer;
        this.gymTrainerID = gymTrainerID;
        this.roles = roles;
        this.userName = userName;
    }

    public Admin() {
    }

    public SubscriptionCard getSubscriptionCard() {
        return subscriptionCard;
    }

    public void setSubscriptionCard(SubscriptionCard subscriptionCard) {
        this.subscriptionCard = subscriptionCard;
    }

    public long getSubscriptionCardID() {
        return subscriptionCardID;
    }

    public void setSubscriptionCardID(long subscriptionCardID) {
        this.subscriptionCardID = subscriptionCardID;
    }

    public GymSubscription getGymSubscription() {
        return gymSubscription;
    }

    public void setGymSubscription(GymSubscription gymSubscription) {
        this.gymSubscription = gymSubscription;
    }

    public long getGymSubscriptionID() {
        return gymSubscriptionID;
    }

    public void setGymSubscriptionID(long gymSubscriptionID) {
        this.gymSubscriptionID = gymSubscriptionID;
    }

    public GymMember getGymMember() {
        return gymMember;
    }

    public void setGymMember(GymMember gymMember) {
        this.gymMember = gymMember;
    }

    public long getGymMemberID() {
        return gymMemberID;
    }

    public void setGymMemberID(long gymMemberID) {
        this.gymMemberID = gymMemberID;
    }

    public GymTrainer getGymTrainer() {
        return gymTrainer;
    }

    public void setGymTrainer(GymTrainer gymTrainer) {
        this.gymTrainer = gymTrainer;
    }

    public long getGymTrainerID() {
        return gymTrainerID;
    }

    public void setGymTrainerID(long gymTrainerID) {
        this.gymTrainerID = gymTrainerID;
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
}
