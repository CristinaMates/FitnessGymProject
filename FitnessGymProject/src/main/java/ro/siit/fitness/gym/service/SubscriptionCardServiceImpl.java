package ro.siit.fitness.gym.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ro.siit.fitness.gym.dao.GymMemberDAO;
import ro.siit.fitness.gym.dao.SubscriptionCardDAO;
import ro.siit.fitness.gym.dao.SubscriptionCardDAOImpl;
import ro.siit.fitness.gym.domain.GymMember;
import ro.siit.fitness.gym.domain.SubscriptionCard;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionCardServiceImpl implements SubscriptionCardService {
    private static final org.slf4j.Logger LOGGER= LoggerFactory.getLogger(SubscriptionCardDAOImpl.class);

    @Qualifier("subscriptionCardDAO")
    @Autowired
    private SubscriptionCardDAO subscriptionCardDAO;


    @Autowired
    private GymMemberDAO gymMemberDAO;

    @Override
    public List<SubscriptionCard> getAll() {

        List<SubscriptionCard> subscriptionCards = subscriptionCardDAO.getAll();

        for (SubscriptionCard card: subscriptionCards) {
            solve(card);
        }

        return subscriptionCards;
    }


    private void solve(SubscriptionCard subscriptionCard) {
        subscriptionCard.setGymMember(gymMemberDAO.findById(subscriptionCard.getGymMemberId()));
    }


    @Override
    public void createSubscriptionCard(SubscriptionCard subscriptionCard){
        GymMember gymMember = gymMemberDAO.create(subscriptionCard.getGymMember());
        subscriptionCard.setGymMember(gymMember);

        subscriptionCardDAO.create(subscriptionCard);


    }

    @Override
    public SubscriptionCard findById(long id) {
        SubscriptionCard s =  subscriptionCardDAO.findById(id);
        solve(s);
        return s;

    }

    @Override
    public void updateGymSubscriptionCard(SubscriptionCard subscriptionCard, long id) {
        subscriptionCardDAO.update(subscriptionCard);

    }

    @Override
    public void removeGymSubscriptionCard(long id) {
//        subscriptionCards = subscriptionCards.stream().filter(c -> c.getId() != id).collect(Collectors.toList());
//        LOGGER.info("Delete performed for{}", id);

    }
}
