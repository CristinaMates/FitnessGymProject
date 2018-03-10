package ro.siit.fitness.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.siit.fitness.gym.domain.GymMember;
import ro.siit.fitness.gym.domain.GymSubscription;
import ro.siit.fitness.gym.domain.GymTrainer;
import ro.siit.fitness.gym.domain.SubscriptionCard;
import ro.siit.fitness.gym.dto.CreateGymMemberRegistration;
import ro.siit.fitness.gym.service.AdminService;
import ro.siit.fitness.gym.service.GymMemberService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private GymMemberService gymMemberService;

    @RequestMapping(value = "/gymmembers", method = RequestMethod.GET)
    public String listGymMembers(Model model, HttpServletRequest request) {
        List<GymMember> gymMembers = gymMemberService.getAll();
        model.addAttribute("gymMembers", gymMembers);
        model.addAttribute("createGymMemberRegistration", new CreateGymMemberRegistration());
        return "listGymMembers";
    }
    @RequestMapping (value = "/gymmembers", method = RequestMethod.POST)
    public String createGymMember(CreateGymMemberRegistration gymMemberRegistration, Model model) {
        GymMember gymMember = getGymMember(gymMemberRegistration);
        gymMemberService.createGymMember(gymMember);
        return "redirect:/gymmembers";
    }

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
        gymTrainer.setProgram(gymMemberRegistration.getProgram());

        GymSubscription gymSubscription = new GymSubscription();
        gymSubscription.setType(gymMemberRegistration.getType());
        gymSubscription.setPrice(gymMemberRegistration.getPrice());

        gymMember.setGymTrainer(gymTrainer);
        gymMember.setGymSubscription(gymSubscription);

        return gymMember;
    }


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
        createGymMemberRegistration.setProgram(gymMember.getGymTrainer().getProgram());

        createGymMemberRegistration.setType(gymMember.getSubscription().getType());
        createGymMemberRegistration.setPrice(gymMember.getSubscription().getPrice());

        return createGymMemberRegistration;
    }

}
