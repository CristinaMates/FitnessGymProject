package ro.siit.fitness.gym.domain;

import java.util.Objects;

public class GymLocation {

    private GymAddress address;
    private String schedule;
    private WeekDays days;

    public GymLocation() {

    }

    public GymLocation(int capacity, GymAddress address, String schedule, WeekDays days) {
        this.address = address;
        this.schedule = schedule;
        this.days = days;
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

    @Override
    public String toString() {
        return "GymLocation{" +
                ", address=" + address +
                ", schedule='" + schedule + '\'' +
                ", days=" + days +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GymLocation that = (GymLocation) o;

        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (schedule != null ? !schedule.equals(that.schedule) : that.schedule != null) return false;
        return days == that.days;
    }

    @Override
    public int hashCode() {
        int result = address != null ? address.hashCode() : 0;
        result = 31 * result + (schedule != null ? schedule.hashCode() : 0);
        result = 31 * result + (days != null ? days.hashCode() : 0);
        return result;
    }
}