package ro.siit.fitness.gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.fitness.gym.dao.GymMemberDAO;
import ro.siit.fitness.gym.dao.GymTrainerDAO;
import ro.siit.fitness.gym.dao.ProgramDAO;
import ro.siit.fitness.gym.dao.ReservationDAO;
import ro.siit.fitness.gym.domain.GymMember;
import ro.siit.fitness.gym.domain.GymTrainer;
import ro.siit.fitness.gym.domain.Program;
import ro.siit.fitness.gym.domain.Reservation;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private SecurityService securityService;

    @Autowired
    private ReservationDAO reservationDAO;

    @Autowired
    private GymMemberDAO gymMemberDAO;

    @Autowired
    private GymTrainerDAO gymTrainerDAO;

    @Autowired
    private ProgramDAO programDAO;

    @Override
    @RolesAllowed({"Admin", "User"})
    public List<Reservation> getAll() {
        List<Reservation> reservations = reservationDAO.getAll();

        for (Reservation reservation: reservations) {
            solve(reservation);
        }

        return reservations;
    }

    private void solve(Reservation reservation) {
        reservation.setGymTrainer(gymTrainerDAO.findById(reservation.getGymTrainerID()));
        reservation.setProgram(programDAO.findById(reservation.getProgramID()));
        reservation.setGymMember(gymMemberDAO.findById(reservation.getGymMemberID()));
    }

    @Override
    public void createReservation(Reservation reservation) {
        GymTrainer gymTrainer = gymTrainerDAO.create(reservation.getGymTrainer());
        reservation.setGymTrainer(gymTrainer);

        Program program = programDAO.create(reservation.getProgram());
        reservation.setProgram(program);

        GymMember gymMember = gymMemberDAO.create(reservation.getGymMember());
        reservation.setGymMember(gymMember);

        reservationDAO.create(reservation);


    }

    @Override
    public void updateReservation(Reservation reservation, long id) {
       reservationDAO.update(reservation);
    }

    @Override
    public Reservation getById(long id) {
        Reservation r =  reservationDAO.findById(id);
        solve(r);
        return r;
    }

    @Override
    public void removeReservation(long id) {
      //  reservations = reservations.stream().filter(c -> c.getId() != id).collect(Collectors.toList());

    }
}
