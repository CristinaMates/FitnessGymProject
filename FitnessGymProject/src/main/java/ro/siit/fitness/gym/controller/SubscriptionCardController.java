package ro.siit.fitness.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import ro.siit.fitness.gym.domain.GymMember;
import ro.siit.fitness.gym.domain.SubscriptionCard;
import ro.siit.fitness.gym.dto.CreateGymSubscriptionCard;
import ro.siit.fitness.gym.service.SubscriptionCardService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.Date;
import java.util.List;

@Controller
public class SubscriptionCardController implements WebMvcConfigurer {
    @Autowired
    private SubscriptionCardService subscriptionCardService;

    @RequestMapping(value = "/subscriptioncards", method = RequestMethod.GET)
    public String listCards(Model model, HttpServletRequest request) {
        List<SubscriptionCard> subscriptionCards = subscriptionCardService.getAll();
        model.addAttribute("subscriptionCards", subscriptionCards);
        model.addAttribute("createGymSubscriptionCard", new CreateGymSubscriptionCard());
        return "listSubscriptionCards";
    }

    @RequestMapping(value = "/subscriptioncards", method = RequestMethod.POST)
    public String createSubscriptionCard(@Valid CreateGymSubscriptionCard gymSubscriptionCard, Model model, BindingResult bindingResult) {
        SubscriptionCard subscriptionCard = getSubscriptionCard(gymSubscriptionCard);
        subscriptionCardService.createSubscriptionCard(subscriptionCard);
        if (bindingResult.hasErrors()) {
            return "listSubscriptionCards";
        }

        return "redirect:/subscriptioncards";
    }

    @RequestMapping(value = "/subscriptioncards/{id}", method = RequestMethod.GET)
    public String getSubscriptionCard(@PathVariable long id, Model model) {
        SubscriptionCard subscriptionCard = subscriptionCardService.getById(id);
        model.addAttribute("updateGymSubscriptionCard", getGymSubcriptionCard(subscriptionCard));
        model.addAttribute("subscriptionCard_id", id);
        return "updateSubscriptionCard";
    }

    @RequestMapping(value = "/subscriptioncards/update/{id}", method = RequestMethod.POST)
    public String updateSubscriptionCard(CreateGymSubscriptionCard gymSubscriptionCard, @PathVariable long id) {
        SubscriptionCard subscriptionCard = getSubscriptionCard(gymSubscriptionCard);
        subscriptionCardService.updateGymSubscriptionCard(subscriptionCard, id);
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

//        if (checkCardAvailability(subscriptionCard)) {
//            subscriptionCard.setStartDate(createGymSubscriptionCard.getStartDate());
//            subscriptionCard.setEndDate(createGymSubscriptionCard.getEndDate());
//        }

        return createGymSubscriptionCard;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {

    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {

    }

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {

    }

    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
        viewControllerRegistry.addViewController("/subscriptioncards").setViewName("listSubscriptionCards");

    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }

    /**
     * created a method to check the expiration date of the card
     * @param subscriptionCard
     * @return permission to enter th gym
     */
//    private boolean checkCardAvailability(SubscriptionCard subscriptionCard) {
//        Date currentDate = new Date();
//        if (subscriptionCard.getEndDate().before(currentDate)) {
//            return true;
//        }
//        return false;
//
//    }

}
