package ro.siit.fitness.gym.dao;

import ro.siit.fitness.gym.domain.GymSubscription;

public interface GymSubscriptionDAO extends AbstractDAO<GymSubscription>{
    GymSubscription findById(long id);
}
