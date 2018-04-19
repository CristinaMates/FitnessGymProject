package ro.siit.fitness.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.AbstractController;
import ro.siit.fitness.gym.domain.GymLocation;
import ro.siit.fitness.gym.domain.GymMember;
import ro.siit.fitness.gym.domain.GymTrainer;
import ro.siit.fitness.gym.dto.CreateGymTrainerProgram;
import ro.siit.fitness.gym.service.GymTrainerService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@Controller
public class GymTrainerController {

    @Autowired
    private GymTrainerService gymTrainerService;

//    @RequestMapping(value = "/trainersmember", method = RequestMethod.GET)
//    public String listTrainerMembers(Model model, HttpServletRequest request) {
//        GymTrainer gymTrainer = new GymTrainer();
//        List<GymMember> gymMembers = gymTrainer.getGymMembers();
//        model.addAttribute("gymMembers", gymMembers);
//        return "listTrainerMembers";
//
//    }

    @RequestMapping(value = "/trainersmember", method = RequestMethod.GET)
    public String listTrainerMembers(Model model, HttpServletRequest request) {
        GymTrainer gymTrainer = new GymTrainer();
        List<GymMember> gymMembers = gymTrainer.getGymMembers();
        model.addAttribute("gymMembers", gymMembers);
        if(!model.containsAttribute("getGymTrainerProgram")){
            model.addAttribute("getGymTrainerProgram", new CreateGymTrainerProgram());
        }
        return "listTrainerMembers";
    }




    @RequestMapping(value = "/trainersprogram", method = RequestMethod.GET)
    private String listTrainersProgram(Model model, HttpServletRequest request) {
        List<GymTrainer> gymTrainers = gymTrainerService.getAll();
        model.addAttribute("gymTrainers", gymTrainers);
        model.addAttribute("getGymTrainerProgram", new CreateGymTrainerProgram());
        return "listTrainersProgram";

    }


    @RequestMapping(value = "/trainersprogram", method = RequestMethod.POST)
    public String createGymTrainer(CreateGymTrainerProgram gymTrainerProgram, Model model) {
        GymTrainer gymTrainer = getGymTrainerProgram(gymTrainerProgram);
        gymTrainerService.createGymTrainer(gymTrainer);
        return "redirect:/trainersprogram";
    }

    @RequestMapping(value = "/trainersprogram/{id}", method = RequestMethod.GET)
    private String getGymTrainer(@PathVariable long id, Model model){
        GymTrainer gymTrainer = gymTrainerService.getById(id);
        model.addAttribute("updateGymTrainerProgram", getGymTrainerProgram(gymTrainer));
        model.addAttribute("gymTrainer_id", id);
        return "updateTrainerProgram";

    }

    //    @RequestMapping(value = "/trainersmember", method = RequestMethod.POST)
//    public String createGymMember(@Valid CreateGymMemberRegistration gymMemberRegistration, BindingResult bindingResult, Model model) {
//
//        if (bindingResult.hasErrors()) {
//            List<String> errors = new LinkedList<>();
//            for (FieldError error: bindingResult.getFieldErrors()) {
//                errors.add("rejected value: "+ error.getRejectedValue() + " for field: "+error.getField());
//            }
//            model.addAttribute("errors", errors);
//            model.addAttribute("createGymMemberRegistration", gymMemberRegistration);
//            return listGymMembers(model, null);
//
//        } else {
//            GymMember gymMember = getGymMember(gymMemberRegistration);
//            adminService.createGymMember(gymMember);
//        }
//
//        return "redirect:/gymmembers";
//    }

    @RequestMapping(value = "/trainersprogram/update/{id}", method = RequestMethod.POST)
    private String updateTrainerProgram(CreateGymTrainerProgram createGymTrainerProgram,@PathVariable long id){
        GymTrainer gymTrainer= getGymTrainerProgram(createGymTrainerProgram);
        gymTrainerService.updateTrainer(gymTrainer,id);
        return "redirect:/trainersprogram";

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

    private CreateGymTrainerProgram getGymTrainerProgram(GymTrainer gymTrainer) {
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
