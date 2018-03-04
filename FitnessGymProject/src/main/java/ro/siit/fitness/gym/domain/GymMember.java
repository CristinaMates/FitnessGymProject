package ro.siit.fitness.gym.domain;

import java.util.Date;

public class GymMember extends Admin {
    SubscriptionCard card;
    Gender gender;
    Date birthDate;
    long id;
    long telephone;
    String email;
    boolean student;
    boolean corporate;
    int memberBudget;

    public GymMember() {
    }


    public GymMember(SubscriptionCard card, Gender gender, Date birthDate, long id, long telephone, String email, boolean student, boolean corporate, int memberBudget) {
        this.card = card;
        this.gender = gender;
        this.birthDate = birthDate;
        this.id = id;
        this.telephone = telephone;
        this.email = email;
        this.student = student;
        this.corporate = corporate;
        this.memberBudget = memberBudget;
    }


    public SubscriptionCard getCard() {
        return card;
    }

    public void setCard(SubscriptionCard card) {
        this.card = card;
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


    @Override
    public String toString() {
        return "GymMember{" +
                "card=" + card +
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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GymMember gymMember = (GymMember) o;

        if (id != gymMember.id) return false;
        if (telephone != gymMember.telephone) return false;
        if (student != gymMember.student) return false;
        if (corporate != gymMember.corporate) return false;
        if (memberBudget != gymMember.memberBudget) return false;
        if (card != null ? !card.equals(gymMember.card) : gymMember.card != null) return false;
        if (gender != null ? !gender.equals(gymMember.gender) : gymMember.gender != null) return false;
        if (birthDate != null ? !birthDate.equals(gymMember.birthDate) : gymMember.birthDate != null) return false;
        return email != null ? email.equals(gymMember.email) : gymMember.email == null;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (card != null ? card.hashCode() : 0);
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

