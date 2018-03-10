package ro.siit.fitness.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.siit.fitness.gym.domain.GymMember;
import ro.siit.fitness.gym.domain.SubscriptionCard;
import ro.siit.fitness.gym.dto.CreateGymMemberRegistration;
import ro.siit.fitness.gym.dto.CreateGymSubscriptionCard;
import ro.siit.fitness.gym.service.SubscriptionCardService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
<<<<<<< HEAD
=======

>>>>>>> 51abaa53bcc3b2a9a0532a7e489bb93149e0a388
@Controller
public class SubscriptionCardController {
    @Autowired
    private SubscriptionCardService subscriptionCardService;

    @RequestMapping(value = "/subscriptioncards", method = RequestMethod.GET)
    public String listCards(Model model, HttpServletRequest request) {
        List<SubscriptionCard> subscriptionCards = subscriptionCardService.getAll();
        model.addAttribute("subscriptionCards", subscriptionCards);
        model.addAttribute("createGymMemberCard", new CreateGymMemberRegistration());
        return "listCards";
    }

    @RequestMapping(value = "/subscriptioncards", method = RequestMethod.POST)
    public String createGymSubscriptionCard(CreateGymSubscriptionCard gymSubscriptionCard, Model model) {
        SubscriptionCard subscriptionCard = getSubscriptionCard(gymSubscriptionCard);
        subscriptionCardService.createSubscriptionCard(subscriptionCard);
        return "redirect:/subcriptioncards";
    }

    @RequestMapping(value = "/subscriptioncards{id}", method = RequestMethod.GET)
    public String getSubscriptionCard(@PathVariable long id, Model model) {
        SubscriptionCard subscriptionCard = subscriptionCardService.getById(id);
        model.addAttribute("updateSubscriptionCardRequest", getSubcriptionCardRequest(subscriptionCard));
        model.addAttribute("subcriptionCard_id", id);
        return "updateSubscriptionCard";
    }

    @RequestMapping(value = "/subscriptioncards/update/{id}", method = RequestMethod.POST)
    public String updateSubscriptionCard(CreateGymSubscriptionCard subscriptionCardRequest, @PathVariable long id) {
        SubscriptionCard subscriptionCard = getSubscriptionCard(subscriptionCardRequest);
        subscriptionCardService.updateGymSubscriptionCard(subscriptionCard, id);
        return "redirect:/subscriptioncards";
    }

    @RequestMapping(value = "subscriptioncards/delete/{id}", method = RequestMethod.POST)
    public String removeGymSubscriptionCard(@PathVariable long id, Model model) {
        subscriptionCardService.removeGymSubscriptionCard(id);
        return "redirect:/subscriptionscards";
    }

    /**
     * Method for getting information needed from dto
     * @param createSubscriptionCard
     * @return a new subscriptionCard with the information got from the dto
     */

    private SubscriptionCard getSubscriptionCard(CreateGymSubscriptionCard createSubscriptionCard) {
        GymMember gymMember = new GymMember();
        gymMember.setFirstName(createSubscriptionCard.getFirstName());
        gymMember.setLastName(createSubscriptionCard.getLastName());

        SubscriptionCard subscriptionCard = new SubscriptionCard();
        subscriptionCard.setId(createSubscriptionCard.getId());
        subscriptionCard.setStartDate(createSubscriptionCard.getStartDate());
        subscriptionCard.setEndDate(createSubscriptionCard.getEndDate());

        subscriptionCard.getGymMember();
        return subscriptionCard;
    }

    /**
     * Method for getting a subscriptionCard request
     * @param subscriptionCard
     * @return a subscriptionCard reference from the dto
     */

    private CreateGymSubscriptionCard getSubcriptionCardRequest(SubscriptionCard subscriptionCard) {
        CreateGymSubscriptionCard createSubscriptionCard = new CreateGymSubscriptionCard();
        createSubscriptionCard.setFirstName(subscriptionCard.getGymMember().getFirstName());
        createSubscriptionCard.setLastName(subscriptionCard.getGymMember().getLastName());

        createSubscriptionCard.setId(subscriptionCard.getId());
        if (checkCardAvailability(subscriptionCard)) {
            subscriptionCard.setStartDate(createSubscriptionCard.getStartDate());
            subscriptionCard.setEndDate(createSubscriptionCard.getEndDate());
        }

        return createSubscriptionCard;
    }

    /**
     * created a method to check the expiration date of the card
     * @param subscriptionCard
     * @return permission to enter th gym
     */
    private boolean checkCardAvailability(SubscriptionCard subscriptionCard) {
        Date currentDate = new Date();
        if (subscriptionCard.getEndDate().before(currentDate)) {
            return true;
        }
        return false;

    }

}
