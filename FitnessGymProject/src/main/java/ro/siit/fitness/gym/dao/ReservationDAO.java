package ro.siit.fitness.gym.dao;

import ro.siit.fitness.gym.domain.Reservation;

public interface ReservationDAO extends AbstractDAO<Reservation> {
    Reservation findById(long id);
}
