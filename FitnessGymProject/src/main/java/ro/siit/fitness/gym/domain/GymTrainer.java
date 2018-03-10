package ro.siit.fitness.gym.domain;

import java.util.List;

public class GymTrainer {

    private String firstNameTrainer;
    private String lastNameTrainer;
    private int capacity;
    private List<GymMember> gymMember;
    private String program;
    private final int MIN_NUMBER_GYM_MEMBERS = 5;
    private final int MAX_NUMBER_GYM_MEMBERS = 20;

    public GymTrainer() {
    }


    public GymTrainer(String firstNameTrainer, String lastNameTrainer, int capacity, List<GymMember> gymMember, String program) {
        this.firstNameTrainer = firstNameTrainer;
        this.lastNameTrainer = lastNameTrainer;
        this.capacity = capacity;
        this.gymMember = gymMember;
        this.program = program;
    }

    public String getFirstNameTrainer() {
        return firstNameTrainer;
    }

    public void setFirstNameTrainer(String firstNameTrainer) {
        this.firstNameTrainer = firstNameTrainer;
    }

    public String getLastNameTrainer() {
        return lastNameTrainer;
    }

    public void setLastNameTrainer(String lastNameTrainer) {
        this.lastNameTrainer = lastNameTrainer;
    }

    public int getMIN_NUMBER_GYM_MEMBERS() {
        return MIN_NUMBER_GYM_MEMBERS;
    }

    public int getMAX_NUMBER_GYM_MEMBERS() {
        return MAX_NUMBER_GYM_MEMBERS;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<GymMember> getGymMember() {
        return gymMember;
    }

    public void setGymMember(List<GymMember> gymMember) {
        this.gymMember = gymMember;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return "GymTrainer{" +
                "firstNameTrainer='" + firstNameTrainer + '\'' +
                ", lastNameTrainer='" + lastNameTrainer + '\'' +
                ", capacity=" + capacity +
                ", gymMember=" + gymMember +
                ", program='" + program + '\'' +
                ", MIN_NUMBER_GYM_MEMBERS=" + MIN_NUMBER_GYM_MEMBERS +
                ", MAX_NUMBER_GYM_MEMBERS=" + MAX_NUMBER_GYM_MEMBERS +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GymTrainer that = (GymTrainer) o;

        if (capacity != that.capacity) return false;
        if (MIN_NUMBER_GYM_MEMBERS != that.MIN_NUMBER_GYM_MEMBERS) return false;
        if (MAX_NUMBER_GYM_MEMBERS != that.MAX_NUMBER_GYM_MEMBERS) return false;
        if (firstNameTrainer != null ? !firstNameTrainer.equals(that.firstNameTrainer) : that.firstNameTrainer != null)
            return false;
        if (lastNameTrainer != null ? !lastNameTrainer.equals(that.lastNameTrainer) : that.lastNameTrainer != null)
            return false;
        if (gymMember != null ? !gymMember.equals(that.gymMember) : that.gymMember != null) return false;
        return program != null ? program.equals(that.program) : that.program == null;
    }

    @Override
    public int hashCode() {
        int result = firstNameTrainer != null ? firstNameTrainer.hashCode() : 0;
        result = 31 * result + (lastNameTrainer != null ? lastNameTrainer.hashCode() : 0);
        result = 31 * result + capacity;
        result = 31 * result + (gymMember != null ? gymMember.hashCode() : 0);
        result = 31 * result + (program != null ? program.hashCode() : 0);
        result = 31 * result + MIN_NUMBER_GYM_MEMBERS;
        result = 31 * result + MAX_NUMBER_GYM_MEMBERS;
        return result;
    }
}