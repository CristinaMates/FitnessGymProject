package ro.siit.fitness.gym.domain;

import java.util.Date;

public class Reservation {
    private GymMember gymMember;
    private Date period;
    private GymTrainer gymTrainer;
    private Program program;
    private long id;
    private long gymMemberID;
    private long gymTrainerID;
    private long programID;


    public Reservation() {
    }

    public Reservation(GymMember gymMember, Date period, GymTrainer gymTrainer, Program program, long id, long gymMemberID, long gymTrainerID, long programID) {
        this.gymMember = gymMember;
        this.period = period;
        this.gymTrainer = gymTrainer;
        this.program = program;
        this.id = id;
        this.gymMemberID = gymMemberID;
        this.gymTrainerID = gymTrainerID;
        this.programID = programID;
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

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

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

    public long getProgramID() {
        return programID;
    }

    public void setProgramID(long programID) {
        this.programID = programID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (id != that.id) return false;
        if (gymMemberID != that.gymMemberID) return false;
        if (gymTrainerID != that.gymTrainerID) return false;
        if (programID != that.programID) return false;
        if (gymMember != null ? !gymMember.equals(that.gymMember) : that.gymMember != null) return false;
        if (period != null ? !period.equals(that.period) : that.period != null) return false;
        if (gymTrainer != null ? !gymTrainer.equals(that.gymTrainer) : that.gymTrainer != null) return false;
        return program != null ? program.equals(that.program) : that.program == null;
    }

    @Override
    public int hashCode() {
        int result = gymMember != null ? gymMember.hashCode() : 0;
        result = 31 * result + (period != null ? period.hashCode() : 0);
        result = 31 * result + (gymTrainer != null ? gymTrainer.hashCode() : 0);
        result = 31 * result + (program != null ? program.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (gymMemberID ^ (gymMemberID >>> 32));
        result = 31 * result + (int) (gymTrainerID ^ (gymTrainerID >>> 32));
        result = 31 * result + (int) (programID ^ (programID >>> 32));
        return result;
    }
}
