package ro.siit.fitness.gym.domain;

import java.util.Date;

public class GymMember {
    private GymSubscription subscription;
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

    public GymMember(GymSubscription subscription, GymTrainer gymTrainer, String firstName, String lastName, Gender gender, Date birthDate, long id, long telephone, String email, boolean student, boolean corporate, int memberBudget) {
        this.subscription = subscription;
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

    public GymSubscription getSubscription() {
        return subscription;
    }

    public void setSubscription(GymSubscription subscription) {
        this.subscription = subscription;
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
                "subscription=" + subscription +
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

        if (id != gymMember.id) return false;
        if (telephone != gymMember.telephone) return false;
        if (student != gymMember.student) return false;
        if (corporate != gymMember.corporate) return false;
        if (memberBudget != gymMember.memberBudget) return false;
        if (subscription != null ? !subscription.equals(gymMember.subscription) : gymMember.subscription != null)
            return false;
        if (gymTrainer != null ? !gymTrainer.equals(gymMember.gymTrainer) : gymMember.gymTrainer != null) return false;
        if (firstName != null ? !firstName.equals(gymMember.firstName) : gymMember.firstName != null) return false;
        if (lastName != null ? !lastName.equals(gymMember.lastName) : gymMember.lastName != null) return false;
        if (gender != gymMember.gender) return false;
        if (birthDate != null ? !birthDate.equals(gymMember.birthDate) : gymMember.birthDate != null) return false;
        return email != null ? email.equals(gymMember.email) : gymMember.email == null;
    }

    @Override
    public int hashCode() {
        int result = subscription != null ? subscription.hashCode() : 0;
        result = 31 * result + (gymTrainer != null ? gymTrainer.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (telephone ^ (telephone >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (student ? 1 : 0);
        result = 31 * result + (corporate ? 1 : 0);
        result = 31 * result + memberBudget;
        return result;
    }
}

