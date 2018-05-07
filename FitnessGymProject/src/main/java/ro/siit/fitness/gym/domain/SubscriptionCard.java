package ro.siit.fitness.gym.domain;

import java.util.Date;

public class SubscriptionCard {

    private long id;
    private Date startDate;
    private Date endDate;
    private GymMember gymMember;
    private long gymMemberId;


    public SubscriptionCard() {
    }

    public SubscriptionCard(long id, Date startDate, Date endDate, GymMember gymMember) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.gymMember = gymMember;
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

    public long getGymMemberId() {
        return gymMemberId;
    }

    public void setGymMemberId(long gymMemberId) {
        this.gymMemberId = gymMemberId;
    }

    @Override
    public String toString() {
        return "SubscriptionCard{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", gymMember=" + gymMember +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubscriptionCard that = (SubscriptionCard) o;

        if (id != that.id) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        return gymMember != null ? gymMember.equals(that.gymMember) : that.gymMember == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (gymMember != null ? gymMember.hashCode() : 0);
        return result;
    }
}
