package ro.siit.fitness.gym.dao;

import ro.siit.fitness.gym.domain.SubscriptionCard;

public interface SubscriptionCardDAO extends AbstractDAO<SubscriptionCard> {

    SubscriptionCard findById(long id);
}
