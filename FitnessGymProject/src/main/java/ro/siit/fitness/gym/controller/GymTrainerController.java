package ro.siit.fitness.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.siit.fitness.gym.domain.GymLocation;
import ro.siit.fitness.gym.domain.GymMember;
import ro.siit.fitness.gym.domain.GymTrainer;
import ro.siit.fitness.gym.dto.CreateGymTrainerProgram;
import ro.siit.fitness.gym.service.GymMemberService;
import ro.siit.fitness.gym.service.GymTrainerService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class GymTrainerController {

    @Autowired
    private GymTrainerService gymTrainerService;

    @RequestMapping(value = "/trainersmember", method = RequestMethod.GET)
    public String listTrainerMembers(Model model, HttpServletRequest request) {
        GymTrainer gymTrainer = new GymTrainer();
        List<GymMember> gymMembers = gymTrainer.getGymMembers();
        model.addAttribute("gymMembers", gymMembers);
        return "listTrainerMembers";

    }

    @RequestMapping(value = "/trainerprogram", method = RequestMethod.GET)
    private String listTrainerProgram(Model model, HttpServletRequest request) {
        String gymTrainer = gymTrainerService.getTrainerProgram();
        model.addAttribute("gymTrainer", gymTrainer);
        model.addAttribute("createGymTrainerProgram", new CreateGymTrainerProgram());
        return "listTrainerProgram";

    }

    private GymTrainer getGymTrainerProgram(CreateGymTrainerProgram createGymTrainerProgram) {

        GymTrainer gymTrainer = new GymTrainer();
        gymTrainer.setFirstNameTrainer(createGymTrainerProgram.getFirstNameTrainer());
        gymTrainer.setLastNameTrainer(createGymTrainerProgram.getLastNameTrainer());
        gymTrainer.setCapacity(createGymTrainerProgram.getCapacity());
        gymTrainer.setGymMembers(createGymTrainerProgram.getGymMembers());
        gymTrainer.setProgram(createGymTrainerProgram.getProgram());

        GymLocation gymLocation = new GymLocation();
        gymLocation.setAddress(createGymTrainerProgram.getAddress());
        gymLocation.setSchedule(createGymTrainerProgram.getSchedule());
        gymLocation.setDays(createGymTrainerProgram.getDays());

        gymTrainer.setGymLocation(gymLocation);

        return gymTrainer;
    }

    private CreateGymTrainerProgram createGymTrainerProgram(GymTrainer gymTrainer) {
        CreateGymTrainerProgram createGymTrainerProgram = new CreateGymTrainerProgram();

        createGymTrainerProgram.setFirstNameTrainer(gymTrainer.getFirstNameTrainer());
        createGymTrainerProgram.setLastNameTrainer(gymTrainer.getLastNameTrainer());
        createGymTrainerProgram.setCapacity(gymTrainer.getCapacity());
        createGymTrainerProgram.setGymMembers(gymTrainer.getGymMembers());
        createGymTrainerProgram.setProgram(gymTrainer.getProgram());

        createGymTrainerProgram.setAddress(gymTrainer.getGymLocation().getAddress());
        createGymTrainerProgram.setSchedule(gymTrainer.getGymLocation().getSchedule());
        createGymTrainerProgram.setDays(gymTrainer.getGymLocation().getDays());

        return createGymTrainerProgram;
    }


}
