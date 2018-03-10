package ro.siit.fitness.gym.service;

import org.springframework.stereotype.Service;
import ro.siit.fitness.gym.domain.SubscriptionCard;

import java.util.ArrayList;
import java.util.List;
@Service
public class SubscriptionCardServiceImpl implements SubscriptionCardService {

    private List<SubscriptionCard> subscriptionCards = new ArrayList<>();
    @Override
    public List<SubscriptionCard> getAll() {
        return subscriptionCards;
    }

    @Override
    public void createSubscriptionCard(SubscriptionCard subscriptionCard) {
        subscriptionCards.add(subscriptionCard);

    }
}
