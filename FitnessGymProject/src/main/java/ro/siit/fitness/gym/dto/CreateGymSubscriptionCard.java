package ro.siit.fitness.gym.dto;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import ro.siit.fitness.gym.domain.GymMember;
import ro.siit.fitness.gym.domain.SubscriptionCard;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class CreateGymSubscriptionCard {
    /*
    Gym member fields with added validators
     */
    private GymMember gymMember;
    @NotEmpty(message = "Enter gym member first name")
    private String firstName;
    @NotEmpty(message = "Enter gym member second name")
    private String lastName;

    /*
    SubscriptionCard fields with added validators
     */
    private SubscriptionCard subscriptionCard;
    private long id;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @NotNull(message = "You have not selected a start date")
    private Date startDate;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @NotNull(message = "You have not selected a end date")
    private Date endDate;

    public SubscriptionCard getSubscriptionCard() {
        return subscriptionCard;
    }

    public void setSubscriptionCard(SubscriptionCard subscriptionCard) {
        this.subscriptionCard = subscriptionCard;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public GymMember getGymMember() {
        return gymMember;
    }

    public void setGymMember(GymMember gymMember) {
        this.gymMember = gymMember;
    }
}
