package ro.siit.fitness.gym.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import ro.siit.fitness.gym.domain.Gender;
import ro.siit.fitness.gym.domain.GymSubscription;
import ro.siit.fitness.gym.domain.GymTrainer;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class CreateGymMemberRegistration {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String gender;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date birthDate;

    @Length(min=5, max=10)
    private String telephone;

    @Email
    private String email;
    private boolean student;
    private boolean corporate;
    private long id;

    private GymTrainer gymTrainer;

    @NotBlank
    private String firstNameTrainer;

    @NotBlank
    private String lastNameTrainer;

    @NotBlank
    private String program;

    private GymSubscription gymSubscription;

    @NotBlank
    private String type;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date startDate;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date endDate;

    @NotNull
    private float price;
    private float discount;


    public GymTrainer getGymTrainer() {
        return gymTrainer;
    }

    public void setGymTrainer(GymTrainer gymTrainer) {
        this.gymTrainer = gymTrainer;
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

    public GymSubscription getGymSubscription() {
        return gymSubscription;
    }

    public void setGymSubscription(GymSubscription gymSubscription) {
        this.gymSubscription = gymSubscription;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public boolean isCorporate() {
        return corporate;
    }

    public void setCorporate(boolean corporate) {
        this.corporate = corporate;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
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
}
