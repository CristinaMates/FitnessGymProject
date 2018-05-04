package ro.siit.fitness.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.siit.fitness.gym.domain.GymMember;
import ro.siit.fitness.gym.domain.GymSubscription;
import ro.siit.fitness.gym.domain.GymTrainer;
import ro.siit.fitness.gym.domain.Program;
import ro.siit.fitness.gym.dto.CreateGymMemberRegistration;
import ro.siit.fitness.gym.service.AdminService;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@Controller
public class AdminController extends AbstractController{

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/gymmembers", method = RequestMethod.GET)
    public String listGymMembers(Model model, HttpServletRequest request) {
        List<GymMember> gymMembers = adminService.getAll();
        model.addAttribute("gymMembers", gymMembers);
        if(!model.containsAttribute("createGymMemberRegistration")){
            model.addAttribute("createGymMemberRegistration", new CreateGymMemberRegistration());
        }
        return "listGymMembers";
    }

    @RequestMapping(value = "/gymmembers", method = RequestMethod.POST)
    public String createGymMember(@Valid CreateGymMemberRegistration gymMemberRegistration, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            List<String> errors = new LinkedList<>();
            for (FieldError error: bindingResult.getFieldErrors()) {
                errors.add("rejected value: "+ error.getRejectedValue() + " for field: "+error.getField());
            }
            model.addAttribute("errors", errors);
            model.addAttribute("createGymMemberRegistration", gymMemberRegistration);
            return listGymMembers(model, null);

        } else {
            GymMember gymMember = getGymMember(gymMemberRegistration);
            adminService.createGymMember(gymMember);
        }

        return "redirect:/gymmembers";
    }

    @RequestMapping(value = "/gymmembers/{id}", method = RequestMethod.GET)
    public String getGymMember(@PathVariable long id, Model model) {
        GymMember gymMember = adminService.findById(id);
        model.addAttribute("updateGymMemberRegistration", getGymMemberRegistration(gymMember));
        model.addAttribute("gymMember_id", id);
        return "updateGymMember";
    }

    @RequestMapping(value = "/gymmembers/update/{id}", method = RequestMethod.POST)
    public String updateGymMember(CreateGymMemberRegistration gymMemberRegistration, @PathVariable long id) {
        GymMember gymMember = getGymMember(gymMemberRegistration);
        adminService.updateGymMember(gymMember, id);

        return "redirect:/gymmembers";
    }

    @RequestMapping(value = "/gymmembers/delete/{id}", method = RequestMethod.POST)
    public String removeGymMember(@PathVariable long id, Model model) {
        adminService.removeGymMember(id);

        return "redirect:/gymmembers";
    }

    /**
     * Method for recording GymMember data
     *
     * @param gymMemberRegistration
     * @return
     */

    private GymMember getGymMember(CreateGymMemberRegistration gymMemberRegistration) {

        GymMember gymMember = new GymMember();
        gymMember.setFirstName(gymMemberRegistration.getFirstName());
        gymMember.setLastName(gymMemberRegistration.getLastName());
        gymMember.setGender(gymMemberRegistration.getGender());
        gymMember.setBirthDate(gymMemberRegistration.getBirthDate());
        gymMember.setTelephone(gymMemberRegistration.getTelephone());
        gymMember.setEmail(gymMemberRegistration.getEmail());
        gymMember.setStudent(gymMemberRegistration.isStudent());
        gymMember.setCorporate(gymMemberRegistration.isCorporate());

        GymTrainer gymTrainer = new GymTrainer();
        gymTrainer.setFirstNameTrainer(gymMemberRegistration.getFirstNameTrainer());
        gymTrainer.setLastNameTrainer(gymMemberRegistration.getLastNameTrainer());

        Program program = new Program();
        program.setClasses(gymMemberRegistration.getClasses());

        GymSubscription gymSubscription = new GymSubscription();
        gymSubscription.setType(gymMemberRegistration.getType());
        gymSubscription.setPrice(gymMemberRegistration.getPrice());
        gymSubscription.setDiscount(gymMemberRegistration.getDiscount());
        gymSubscription.setStartDate(gymMemberRegistration.getStartDate());
        gymSubscription.setEndDate(gymMemberRegistration.getEndDate());

        gymMember.setGymTrainer(gymTrainer);
        gymMember.setGymSubscription(gymSubscription);
        gymMember.setProgram(program);

        return gymMember;
    }

    /**
     * Method for updating GymMember registration
     *
     * @param gymMember
     * @return
     */

    private CreateGymMemberRegistration getGymMemberRegistration(GymMember gymMember) {
        CreateGymMemberRegistration createGymMemberRegistration = new CreateGymMemberRegistration();

        createGymMemberRegistration.setFirstName(gymMember.getFirstName());
        createGymMemberRegistration.setLastName(gymMember.getLastName());
        createGymMemberRegistration.setGender(gymMember.getGender());
        createGymMemberRegistration.setBirthDate(gymMember.getBirthDate());
        createGymMemberRegistration.setTelephone(gymMember.getTelephone());
        createGymMemberRegistration.setEmail(gymMember.getEmail());
        createGymMemberRegistration.setStudent(gymMember.isStudent());
        createGymMemberRegistration.setCorporate(gymMember.isCorporate());

        createGymMemberRegistration.setFirstNameTrainer(gymMember.getGymTrainer().getFirstNameTrainer());
        createGymMemberRegistration.setLastNameTrainer(gymMember.getGymTrainer().getLastNameTrainer());

        createGymMemberRegistration.setClasses(gymMember.getProgram().getClasses());

        createGymMemberRegistration.setType(gymMember.getGymSubscription().getType());
        createGymMemberRegistration.setPrice(gymMember.getGymSubscription().getPrice());
        createGymMemberRegistration.setDiscount(gymMember.getGymSubscription().getDiscount());
        createGymMemberRegistration.setStartDate(gymMember.getGymSubscription().getStartDate());
        createGymMemberRegistration.setEndDate(gymMember.getGymSubscription().getEndDate());

        return createGymMemberRegistration;
    }
}