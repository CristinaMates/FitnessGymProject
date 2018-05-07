package ro.siit.fitness.gym.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

public class GymMember {
    private GymSubscription gymSubscription;
    private GymTrainer gymTrainer;
    private Program program;
    private String firstName;
    private String lastName;
    private Gender gender = Gender.MALE;
    private Date birthDate;
    private long id;
    private String telephone;
    private String email;
    private boolean student;
    private boolean corporate;
    private long gymSubscriptionID;
    private long gymTrainerID;
    private long programID;

    public GymMember() {
    }

    public GymMember(GymSubscription gymSubscription, GymTrainer gymTrainer, Program program, String firstName, String lastName, Gender gender, Date birthDate, long id, String telephone, String email, boolean student, boolean corporate, long gymSubscriptionID, long gymTrainerID, long programID) {
        this.gymSubscription = gymSubscription;
        this.gymTrainer = gymTrainer;
        this.program = program;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.id = id;
        this.telephone = telephone;
        this.email = email;
        this.student = student;
        this.corporate = corporate;
        this.gymSubscriptionID = gymSubscriptionID;
        this.gymTrainerID = gymTrainerID;
        this.programID = programID;
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

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
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

    public long getGymSubscriptionID() {
        return gymSubscriptionID;
    }

    public void setGymSubscriptionID(long gymSubscriptionID) {
        this.gymSubscriptionID = gymSubscriptionID;
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

        GymMember gymMember = (GymMember) o;

        if (id != gymMember.id) return false;
        if (student != gymMember.student) return false;
        if (corporate != gymMember.corporate) return false;
        if (gymSubscriptionID != gymMember.gymSubscriptionID) return false;
        if (gymTrainerID != gymMember.gymTrainerID) return false;
        if (programID != gymMember.programID) return false;
        if (gymSubscription != null ? !gymSubscription.equals(gymMember.gymSubscription) : gymMember.gymSubscription != null)
            return false;
        if (gymTrainer != null ? !gymTrainer.equals(gymMember.gymTrainer) : gymMember.gymTrainer != null) return false;
        if (program != null ? !program.equals(gymMember.program) : gymMember.program != null) return false;
        if (firstName != null ? !firstName.equals(gymMember.firstName) : gymMember.firstName != null) return false;
        if (lastName != null ? !lastName.equals(gymMember.lastName) : gymMember.lastName != null) return false;
        if (gender != gymMember.gender) return false;
        if (birthDate != null ? !birthDate.equals(gymMember.birthDate) : gymMember.birthDate != null) return false;
        if (telephone != null ? !telephone.equals(gymMember.telephone) : gymMember.telephone != null) return false;
        return email != null ? email.equals(gymMember.email) : gymMember.email == null;
    }

    @Override
    public int hashCode() {
        int result = gymSubscription != null ? gymSubscription.hashCode() : 0;
        result = 31 * result + (gymTrainer != null ? gymTrainer.hashCode() : 0);
        result = 31 * result + (program != null ? program.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (student ? 1 : 0);
        result = 31 * result + (corporate ? 1 : 0);
        result = 31 * result + (int) (gymSubscriptionID ^ (gymSubscriptionID >>> 32));
        result = 31 * result + (int) (gymTrainerID ^ (gymTrainerID >>> 32));
        result = 31 * result + (int) (programID ^ (programID >>> 32));
        return result;
    }
}