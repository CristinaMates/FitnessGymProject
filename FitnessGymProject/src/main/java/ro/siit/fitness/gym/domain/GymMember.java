package ro.siit.fitness.gym.domain;

import java.util.Date;
import java.util.Objects;

public class GymMember {
    private GymSubscription gymSubscription;
    private GymTrainer gymTrainer;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Date birthDate;
    private long id;
    private long telephone;
    private String email;
    private boolean student;
    private boolean corporate;
    private int memberBudget;

    public GymMember() {
    }

    public GymMember(GymSubscription gymSubscription, GymTrainer gymTrainer, String firstName, String lastName, Gender gender, Date birthDate, long id, long telephone, String email, boolean student, boolean corporate, int memberBudget) {
        this.gymSubscription = gymSubscription;
        this.gymTrainer = gymTrainer;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.id = id;
        this.telephone = telephone;
        this.email = email;
        this.student = student;
        this.corporate = corporate;
        this.memberBudget = memberBudget;
    }

    public GymSubscription getGymSubscription() {
        return gymSubscription;
    }

    public void setGymSubscription(GymSubscription gymSubscription) {
        this.gymSubscription = gymSubscription;
    }

    public GymTrainer getGymTrainer() {
        return gymTrainer;
    }

    public void setGymTrainer(GymTrainer gymTrainer) {
        this.gymTrainer = gymTrainer;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
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

    public int getMemberBudget() {
        return memberBudget;
    }

    public void setMemberBudget(int memberBudget) {
        this.memberBudget = memberBudget;
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

    @Override
    public String toString() {
        return "GymMember{" +
                "subscription=" + gymSubscription +
                ", gymTrainer=" + gymTrainer +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", id=" + id +
                ", telephone=" + telephone +
                ", email='" + email + '\'' +
                ", student=" + student +
                ", corporate=" + corporate +
                ", memberBudget=" + memberBudget +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GymMember gymMember = (GymMember) o;
        return id == gymMember.id &&
                telephone == gymMember.telephone &&
                student == gymMember.student &&
                corporate == gymMember.corporate &&
                memberBudget == gymMember.memberBudget &&
                Objects.equals(gymSubscription, gymMember.gymSubscription) &&
                Objects.equals(gymTrainer, gymMember.gymTrainer) &&
                Objects.equals(firstName, gymMember.firstName) &&
                Objects.equals(lastName, gymMember.lastName) &&
                gender == gymMember.gender &&
                Objects.equals(birthDate, gymMember.birthDate) &&
                Objects.equals(email, gymMember.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(gymSubscription, gymTrainer, firstName, lastName, gender, birthDate, id, telephone, email, student, corporate, memberBudget);
    }
}

