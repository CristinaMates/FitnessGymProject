package ro.siit.fitness.gym.domain;

import java.util.List;

public class GymTrainer {

    private String firstNameTrainer;
    private String lastNameTrainer;
    private GymMember gymMember;
    private List<String> program;
    private final int MIN_NUMBER_GYM_MEMBERS = 5;
    private final int MAX_NUMBER_GYM_MEMBERS = 20;

    public GymTrainer() {
    }

    public GymTrainer(String firstNameTrainer, String lastNameTrainer, GymMember gymMember, List<String> program) {
        this.firstNameTrainer = firstNameTrainer;
        this.lastNameTrainer = lastNameTrainer;
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

    public GymMember getGymMember() {
        return gymMember;
    }

    public void setGymMember(GymMember gymMember) {
        this.gymMember = gymMember;
    }

    public List<String> getProgram() {
        return program;
    }

    public void setProgram(List<String> program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return "GymTrainer{" +
                "firstNameTrainer='" + firstNameTrainer + '\'' +
                ", lastNameTrainer='" + lastNameTrainer + '\'' +
                ", gymMember=" + gymMember +
                ", program=" + program +
                ", MIN_NUMBER_GYM_MEMBERS=" + MIN_NUMBER_GYM_MEMBERS +
                ", MAX_NUMBER_GYM_MEMBERS=" + MAX_NUMBER_GYM_MEMBERS +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GymTrainer that = (GymTrainer) o;

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
        result = 31 * result + (gymMember != null ? gymMember.hashCode() : 0);
        result = 31 * result + (program != null ? program.hashCode() : 0);
        result = 31 * result + MIN_NUMBER_GYM_MEMBERS;
        result = 31 * result + MAX_NUMBER_GYM_MEMBERS;
        return result;
    }
}