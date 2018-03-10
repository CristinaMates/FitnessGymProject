package ro.siit.fitness.gym.service;

import org.springframework.stereotype.Service;
import ro.siit.fitness.gym.domain.SubscriptionCard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionCardServiceImpl implements SubscriptionCardService {

    private List<SubscriptionCard> subscriptionCards = new ArrayList<>();
    @Override
    public List<SubscriptionCard> getAll() {
        return subscriptionCards;
    }

    @Override
    public void createSubscriptionCard(SubscriptionCard subscriptionCard) {
        subscriptionCard.setId(System.currentTimeMillis());
        subscriptionCards.add(subscriptionCard);

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

    }
}
