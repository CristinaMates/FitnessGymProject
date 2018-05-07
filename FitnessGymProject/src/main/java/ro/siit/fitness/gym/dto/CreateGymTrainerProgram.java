package ro.siit.fitness.gym.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;
import ro.siit.fitness.gym.domain.*;

import javax.validation.constraints.NotNull;
import java.util.List;

public class CreateGymTrainerProgram {
    @NotBlank
    private String firstNameTrainer;
    @NotBlank
    private String lastNameTrainer;

    @NotBlank
    private Program program;
    private final int MIN_NUMBER_GYM_MEMBERS = 5;
    private final int MAX_NUMBER_GYM_MEMBERS = 20;


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

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public int getMIN_NUMBER_GYM_MEMBERS() {
        return MIN_NUMBER_GYM_MEMBERS;
    }

    public int getMAX_NUMBER_GYM_MEMBERS() {
        return MAX_NUMBER_GYM_MEMBERS;
    }
}
