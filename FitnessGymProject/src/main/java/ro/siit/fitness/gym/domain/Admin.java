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
/*
    public String checkCardAvability(SubscriptionCard card) {
        //if endDate > currentDate all good else valability false
        boolean valability=true;
        //if valability=true sout card is available else card expired
    }

    public String checkTrainerAvalability(GymTrainer trainer){
        //if gymtrainers clients.lenght < max_capacity trainer valability=true else valability=false
        boolean valability=true;
        //if valability=true trainer is available else program full
    }

    public String[] getTrainerByProgram(String[] trainers){
        //get programs and print trainers and schedule
        return trainers;
    }

    public String printCard(GymTrainer trainer, GymMember member, GymSubscription subscription, SubscriptionCard card){
        //if checkTrainer=true get member data and create new subCard
    }
*/

}
