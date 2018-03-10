package ro.siit.fitness.gym.service;

import org.springframework.stereotype.Service;
import ro.siit.fitness.gym.domain.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {
    public List<Reservation> reservations = new ArrayList<>();

    @Override
    public List<Reservation> getAll() {
        return reservations;
    }

    @Override
    public void createReservation(Reservation reservation) {
        reservation.setId(System.currentTimeMillis());
        reservations.add(reservation);


    }

    @Override
    public void updateReservation(Reservation reservation, long id) {
        reservations = reservations.stream().filter(c -> c.getId() != id).collect(Collectors.toList());
        reservation.setId(id);
        reservations.add(reservation);

    }

    @Override
    public Reservation getById(long id) {
        return reservations.stream().filter(c -> c.getId() == id).collect(Collectors.toList()).get(0);
    }

    @Override
    public void removeReservation(long id) {
        reservations = reservations.stream().filter(c -> c.getId() != id).collect(Collectors.toList());

    }
}
