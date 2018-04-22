package ro.siit.fitness.gym.domain;

public class GymTrainer {

    private long id;
    private String firstNameTrainer;
    private String lastNameTrainer;


    public GymTrainer() {
    }

    public GymTrainer(long id, String firstName, String lastName) {
        this.id = id;
        this.firstNameTrainer = firstName;
        this.lastNameTrainer = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstNameTrainer() {
        return firstNameTrainer;
    }

    public void setFirstNameTrainer(String firstName) {
        this.firstNameTrainer = firstName;
    }

    public String getLastNameTrainer() {
        return lastNameTrainer;
    }

    public void setLastNameTrainer(String lastName) {
        this.lastNameTrainer = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GymTrainer that = (GymTrainer) o;

        if (id != that.id) return false;
        if (firstNameTrainer != null ? !firstNameTrainer.equals(that.firstNameTrainer) : that.firstNameTrainer != null) return false;
        return lastNameTrainer != null ? lastNameTrainer.equals(that.lastNameTrainer) : that.lastNameTrainer == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstNameTrainer != null ? firstNameTrainer.hashCode() : 0);
        result = 31 * result + (lastNameTrainer != null ? lastNameTrainer.hashCode() : 0);
        return result;
    }
}