package ro.siit.fitness.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.siit.fitness.gym.domain.GymMember;
import ro.siit.fitness.gym.domain.SubscriptionCard;
import ro.siit.fitness.gym.dto.CreateGymMemberRegistration;
import ro.siit.fitness.gym.dto.CreateSubscriptionCard;
import ro.siit.fitness.gym.service.SubscriptionCardService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    /**
     * Method for creating a new subscription card
     * @param createSubscriptionCard
     * @return
     */

    private SubscriptionCard getSubscriptionCard(CreateSubscriptionCard createSubscriptionCard){
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
     * Method for printing the card
     * @param subscriptionCard
     * @return
     */

    private CreateSubscriptionCard printCard(SubscriptionCard subscriptionCard){
        CreateSubscriptionCard createSubscriptionCard = new CreateSubscriptionCard();
        createSubscriptionCard.setFirstName(subscriptionCard.getGymMember().getFirstName());
        createSubscriptionCard.setLastName(subscriptionCard.getGymMember().getLastName());

        createSubscriptionCard.setId(subscriptionCard.getId());
        createSubscriptionCard.setStartDate(subscriptionCard.getStartDate());
        createSubscriptionCard.setEndDate(subscriptionCard.getEndDate());

        return createSubscriptionCard;
    }
}
