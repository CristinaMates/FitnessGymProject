package ro.siit.fitness.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.siit.fitness.gym.domain.GymMember;
import ro.siit.fitness.gym.domain.GymTrainer;
import ro.siit.fitness.gym.domain.Reservation;
import ro.siit.fitness.gym.dto.CreateGymMemberReservation;
import ro.siit.fitness.gym.service.ReservationService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    public String listReservations(Model model, HttpServletRequest request) {
        List<Reservation> reservations = reservationService.getAll();
        model.addAttribute("reservations", reservations);
        model.addAttribute("createGymMemberReservation", new CreateGymMemberReservation());

        return "listReservations";
    }

    @RequestMapping(value = "/reservations", method = RequestMethod.POST)
    public String createReservation(CreateGymMemberReservation gymMemberReservation, Model model) {
        Reservation reservation = getReservation(gymMemberReservation);
        reservationService.createReservation(reservation);
        return "redirect:/reservations";
    }

    @RequestMapping(value = "/reservations/{id}", method = RequestMethod.GET)
    public String getReservation(@PathVariable long id, Model model) {
        Reservation reservation = reservationService.getById(id);
        model.addAttribute("updateGymMemberReservation", getReservationRequest(reservation));
        model.addAttribute("reservation_id", id);
        return "updateReservation";
    }

    @RequestMapping(value = "/reservations/update/{id}", method = RequestMethod.POST)
    public String updateReservation(CreateGymMemberReservation createGymMemberReservationRequest, @PathVariable long id) {
        Reservation reservation = getReservation(createGymMemberReservationRequest);
        reservationService.updateReservation(reservation, id);

        return "redirect:/reservations";
    }

    @RequestMapping(value = "/reservations/delete/{id}", method = RequestMethod.POST)
    public String removeReservation(@PathVariable long id, Model model) {
        reservationService.removeReservation(id);

        return "redirect:/reservations";
    }

    /**
     * Method for getting a reservation to the fitness gym
     *
     * @param createGymMemberReservation
     * @return a reservation which contain the following information - First Name and Last Name of the Trainer, programs realized by the Trainer, period available
     */
    private Reservation getReservation(CreateGymMemberReservation createGymMemberReservation) {
        Reservation reservation = new Reservation();
        reservation.setPeriod(createGymMemberReservation.getPeriod());

        GymTrainer gymTrainer = new GymTrainer();
        gymTrainer.setFirstNameTrainer(createGymMemberReservation.getFirstNameTrainer());
        gymTrainer.setLastNameTrainer(createGymMemberReservation.getLastNameTrainer());
        gymTrainer.setProgram(createGymMemberReservation.getProgram());

        GymMember gymMember = new GymMember();
        gymMember.setEmail(createGymMemberReservation.getEmail());

        reservation.setGymTrainer(gymTrainer);
        reservation.setGymMember(gymMember);
        return reservation;
    }

    /**
     * Method for getting a reservation request
     *
     * @param reservation
     * @return a reservation reference from the dto
     */
    private CreateGymMemberReservation getReservationRequest(Reservation reservation) {
        CreateGymMemberReservation createGymMemberReservation = new CreateGymMemberReservation();

        createGymMemberReservation.setEmail(reservation.getGymMember().getEmail());
        createGymMemberReservation.setFirstNameTrainer(reservation.getGymTrainer().getFirstNameTrainer());
        createGymMemberReservation.setLastNameTrainer(reservation.getGymTrainer().getLastNameTrainer());
        createGymMemberReservation.setProgram(reservation.getGymTrainer().getProgram());
        createGymMemberReservation.setPeriod(reservation.getPeriod());

        return createGymMemberReservation;
    }

}
