package ro.siit.fitness.gym.domain;

import java.util.Objects;

public class GymLocation {

    private int capacity;
    private GymAddress address;
    private String schedule;
    private WeekDays days;

    public GymLocation() {

    }

    public GymLocation(int capacity, GymAddress address, String schedule, WeekDays days) {
        this.capacity = capacity;
        this.address = address;
        this.schedule = schedule;
        this.days = days;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
                "capacity=" + capacity +
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
        return capacity == that.capacity &&
                Objects.equals(address, that.address) &&
                Objects.equals(schedule, that.schedule) &&
                days == that.days;
    }

    @Override
    public int hashCode() {

        return Objects.hash(capacity, address, schedule, days);
    }
}
