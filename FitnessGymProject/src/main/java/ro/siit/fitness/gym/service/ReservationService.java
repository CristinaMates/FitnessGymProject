package ro.siit.fitness.gym.service;

import ro.siit.fitness.gym.domain.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAll();

    void createReservation(Reservation reservations);

    void updateReservation(Reservation reservations, long id);

    Reservation getById(long id);

    void removeReservation(long id);
}
