package ro.siit.fitness.gym.domain;

import java.util.Date;

public class Reservation {
    private GymMember gymMember;
    private Date period;
    private GymTrainer gymTrainer;
    private long id;
    private long gymMemberID;
    private long gymTrainerID;

    public long getGymMemberID() {
        return gymMemberID;
    }

    public void setGymMemberID(long gymMemberID) {
        this.gymMemberID = gymMemberID;
    }

    public long getGymTrainerID() {
        return gymTrainerID;
    }

    public void setGymTrainerID(long gymTrainerID) {
        this.gymTrainerID = gymTrainerID;
    }


    public Reservation() {
    }

    public Reservation(GymMember gymMember, Date period, GymTrainer gymTrainer, long id) {
        this.gymMember = gymMember;
        this.period = period;
        this.gymTrainer = gymTrainer;
        this.id = id;
    }

    public GymMember getGymMember() {
        return gymMember;
    }

    public void setGymMember(GymMember gymMember) {
        this.gymMember = gymMember;
    }

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    public GymTrainer getGymTrainer() {
        return gymTrainer;
    }

    public void setGymTrainer(GymTrainer gymTrainer) {
        this.gymTrainer = gymTrainer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (id != that.id) return false;
        if (period != null ? !period.equals(that.period) : that.period != null) return false;
        return gymTrainer != null ? gymTrainer.equals(that.gymTrainer) : that.gymTrainer == null;
    }

    @Override
    public int hashCode() {
        int result = period != null ? period.hashCode() : 0;
        result = 31 * result + (gymTrainer != null ? gymTrainer.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "period='" + period + '\'' +
                ", gymTrainer=" + gymTrainer +
                ", id=" + id +
                '}';
    }
}
