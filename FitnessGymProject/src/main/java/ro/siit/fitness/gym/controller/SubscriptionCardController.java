package ro.siit.fitness.gym.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import ro.siit.fitness.gym.domain.GymMember;
import ro.siit.fitness.gym.domain.SubscriptionCard;
import ro.siit.fitness.gym.dto.CreateGymSubscriptionCard;
import ro.siit.fitness.gym.service.SubscriptionCardService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class SubscriptionCardController {
    @Autowired
    private SubscriptionCardService subscriptionCardService;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SubscriptionCardController.class);

    private Map<String, CreateGymSubscriptionCard> subscriptionCardMap = new HashMap<>();

    @RequestMapping(value = "/subscriptioncards", method = RequestMethod.GET)
    public String listCards(Model model, HttpServletRequest request) {
        List<SubscriptionCard> subscriptionCards = subscriptionCardService.getAll();
        model.addAttribute("subscriptionCards", subscriptionCards);
        model.addAttribute("createGymSubscriptionCard", new CreateGymSubscriptionCard());
        return "listSubscriptionCards";
    }

    @RequestMapping(value = "/subscriptioncards", method = RequestMethod.POST)
    public String createSubscriptionCard(@Valid CreateGymSubscriptionCard gymSubscriptionCard, BindingResult bindingResult, Model model) {
        SubscriptionCard subscriptionCard = getSubscriptionCard(gymSubscriptionCard);
        subscriptionCardService.createSubscriptionCard(subscriptionCard);
        if (bindingResult.hasErrors()) {
            List<String> errors = new LinkedList<>();
            for (FieldError error:
                    bindingResult.getFieldErrors()) {
                errors.add("missing value: "+ error.getRejectedValue()
                        + " for field: "+error.getField());
            }
            model.addAttribute("errors", errors);
            model.addAttribute("createGymSubscriptionCard", gymSubscriptionCard);
            return listCards(model, null);
            } else {
            SubscriptionCard subscriptionCard1 = getSubscriptionCard(gymSubscriptionCard);
            subscriptionCardService.createSubscriptionCard(subscriptionCard1);
            return "redirect:/subscriptioncards";
        }

    }

    @RequestMapping(value = "/subscriptioncards/{id}", method = RequestMethod.GET)
    public String getSubscriptionCard(@PathVariable long id, Model model) {
        SubscriptionCard subscriptionCard = subscriptionCardService.getById(id);
        model.addAttribute("updateGymSubscriptionCard", getGymSubcriptionCard(subscriptionCard));
        model.addAttribute("subscriptionCard_id", id);
        return "updateSubscriptionCard";
    }

    @RequestMapping(value = "/subscriptioncards/update/{id}", method = RequestMethod.POST)
    public String updateSubscriptionCard(@Valid CreateGymSubscriptionCard gymSubscriptionCard, @PathVariable long id, BindingResult bindingResult) {
        SubscriptionCard subscriptionCard = getSubscriptionCard(gymSubscriptionCard);
        subscriptionCardService.updateGymSubscriptionCard(subscriptionCard, id);
//        List<FieldError> errors = bindingResult.getFieldErrors();
//        if (bindingResult.hasErrors()) {
//            for (FieldError error : errors) {
//                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
//            }
//            return "updateSubscriptionCard";
//        }
        return "redirect:/subscriptioncards";
    }

    @RequestMapping(value = "/subscriptioncards/delete/{id}", method = RequestMethod.POST)
    public String removeGymSubscriptionCard(@PathVariable long id, Model model) {
        subscriptionCardService.removeGymSubscriptionCard(id);
        return "redirect:/subscriptioncards";
    }

    /**
     * Method for getting information needed from dto
     *
     * @param gymSubscriptionCard
     * @return a new subscriptionCard with the information got from the dto
     */

    private SubscriptionCard getSubscriptionCard(CreateGymSubscriptionCard gymSubscriptionCard) {
        GymMember gymMember = new GymMember();
        gymMember.setFirstName(gymSubscriptionCard.getFirstName());
        gymMember.setLastName(gymSubscriptionCard.getLastName());

        SubscriptionCard subscriptionCard = new SubscriptionCard();
        subscriptionCard.setId(gymSubscriptionCard.getId());
        subscriptionCard.setStartDate(gymSubscriptionCard.getStartDate());
        subscriptionCard.setEndDate(gymSubscriptionCard.getEndDate());


        subscriptionCard.setGymMember(gymMember);
        return subscriptionCard;
    }

    /**
     * Method for getting a subscriptionCard request
     *
     * @param subscriptionCard
     * @return a subscriptionCard reference from the dto
     */

    private CreateGymSubscriptionCard getGymSubcriptionCard(SubscriptionCard subscriptionCard) {
        CreateGymSubscriptionCard createGymSubscriptionCard = new CreateGymSubscriptionCard();
        createGymSubscriptionCard.setFirstName(subscriptionCard.getGymMember().getFirstName());
        createGymSubscriptionCard.setLastName(subscriptionCard.getGymMember().getLastName());
        createGymSubscriptionCard.setId(subscriptionCard.getId());

        return createGymSubscriptionCard;
    }
}
