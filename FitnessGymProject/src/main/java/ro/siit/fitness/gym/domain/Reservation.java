package ro.siit.fitness.gym.domain;

public class Reservation {
    private String period;
    private GymTrainer gymTrainer;
    private long id;

    public Reservation() {
    }

    public Reservation(String period, GymTrainer gymTrainer, long id) {
        this.period = period;
        this.gymTrainer = gymTrainer;
        this.id = id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public GymTrainer getGymTrainer() {
        return gymTrainer;
    }

    public void setGymTrainer(GymTrainer gymTrainer) {
        this.gymTrainer = gymTrainer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (id != that.id) return false;
        if (period != null ? !period.equals(that.period) : that.period != null) return false;
        return gymTrainer != null ? gymTrainer.equals(that.gymTrainer) : that.gymTrainer == null;
    }

    @Override
    public int hashCode() {
        int result = period != null ? period.hashCode() : 0;
        result = 31 * result + (gymTrainer != null ? gymTrainer.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "period='" + period + '\'' +
                ", gymTrainer=" + gymTrainer +
                ", id=" + id +
                '}';
    }
}
