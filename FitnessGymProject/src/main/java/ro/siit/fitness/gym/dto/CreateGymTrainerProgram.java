package ro.siit.fitness.gym.dto;

import org.hibernate.validator.constraints.NotBlank;
import ro.siit.fitness.gym.domain.GymAddress;
import ro.siit.fitness.gym.domain.GymLocation;
import ro.siit.fitness.gym.domain.GymMember;
import ro.siit.fitness.gym.domain.WeekDays;

import javax.validation.constraints.NotNull;
import java.util.List;

public class CreateGymTrainerProgram {
    @NotBlank
    private String firstNameTrainer;
    @NotBlank
    private String lastNameTrainer;
    @NotNull
    private int capacity;
    private List<GymMember> gymMembers;
    @NotBlank
    private String program;
    private final int MIN_NUMBER_GYM_MEMBERS = 5;
    private final int MAX_NUMBER_GYM_MEMBERS = 20;
    @NotBlank
    private GymLocation gymLocation;
    @NotBlank
    GymAddress address;
    @NotBlank
    String schedule;
    WeekDays days;


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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<GymMember> getGymMembers() {
        return gymMembers;
    }

    public void setGymMembers(List<GymMember> gymMembers) {
        this.gymMembers = gymMembers;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getMIN_NUMBER_GYM_MEMBERS() {
        return MIN_NUMBER_GYM_MEMBERS;
    }

    public int getMAX_NUMBER_GYM_MEMBERS() {
        return MAX_NUMBER_GYM_MEMBERS;
    }

    public GymLocation getGymLocation() {
        return gymLocation;
    }

    public void setGymLocation(GymLocation gymLocation) {
        this.gymLocation = gymLocation;
    }

    public GymAddress getAddress() {
        return address;
    }

    public void setAddress(GymAddress address) {
        this.address = address;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public WeekDays getDays() {
        return days;
    }

    public void setDays(WeekDays days) {
        this.days = days;
    }
}
