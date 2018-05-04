package ro.siit.fitness.gym.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import ro.siit.fitness.gym.domain.GymMember;
import ro.siit.fitness.gym.domain.GymTrainer;
import ro.siit.fitness.gym.domain.Program;
import ro.siit.fitness.gym.domain.Reservation;

import java.util.Date;
import java.util.List;

public class CreateGymMemberReservation {

    private GymMember gymMember;

    @Email
    private String email;

    private GymTrainer gymtrainer;

    @NotBlank
    private String firstNameTrainer;

    @NotBlank
    private String lastNameTrainer;

    private Program programs;

    @NotBlank
    private String classes;

    private Reservation reservation;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date period;

    public GymMember getGymMember() {
        return gymMember;
    }

    public void setGymMember(GymMember gymMember) {
        this.gymMember = gymMember;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GymTrainer getGymtrainer() {
        return gymtrainer;
    }

    public void setGymtrainer(GymTrainer gymtrainer) {
        this.gymtrainer = gymtrainer;
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

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservations) {
        this.reservation = reservations;
    }

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }
}
