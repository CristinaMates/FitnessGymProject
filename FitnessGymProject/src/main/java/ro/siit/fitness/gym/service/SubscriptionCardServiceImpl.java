package ro.siit.fitness.gym.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ro.siit.fitness.gym.dao.SubscriptionCardDAO;
import ro.siit.fitness.gym.dao.SubscriptionCardDAOImpl;
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

    private List<SubscriptionCard> subscriptionCards = new ArrayList<>();

    @Override
    public List<SubscriptionCard> getAll() {
        return subscriptionCards;
    }

    @Override
    public void createSubscriptionCard(SubscriptionCard subscriptionCard){
        subscriptionCard.setId(System.currentTimeMillis());
        subscriptionCards.add(subscriptionCard);
        subscriptionCardDAO.create(subscriptionCard);

    }

    @Override
    public SubscriptionCard getById(long id) {
        return subscriptionCards.stream().filter(c -> c.getId() == id).collect(Collectors.toList()).get(0);
    }

    @Override
    public void updateGymSubscriptionCard(SubscriptionCard subscriptionCard, long id) {
        subscriptionCards = subscriptionCards.stream().filter(c -> c.getId() != id).collect(Collectors.toList());
        subscriptionCard.setId(id);
        subscriptionCards.add(subscriptionCard);

    }

    @Override
    public void removeGymSubscriptionCard(long id) {
        subscriptionCards = subscriptionCards.stream().filter(c -> c.getId() != id).collect(Collectors.toList());
        LOGGER.info("Delete performed for{}", id);

    }
}
