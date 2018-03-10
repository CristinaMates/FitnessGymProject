package ro.siit.fitness.gym.service;

import ro.siit.fitness.gym.domain.SubscriptionCard;

import java.util.List;

public interface SubscriptionCardService {

    List<SubscriptionCard> getAll();

    void createSubscriptionCard(SubscriptionCard subscriptionCard);

    SubscriptionCard getById(long id);

    void updateGymSubscriptionCard(SubscriptionCard subscriptionCard, long id);

    void removeGymSubscriptionCard(long id);
}
