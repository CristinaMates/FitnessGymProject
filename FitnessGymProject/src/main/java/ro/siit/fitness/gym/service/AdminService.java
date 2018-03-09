package ro.siit.fitness.gym.service;

import ro.siit.fitness.gym.domain.SubscriptionCard;

import java.util.List;

public interface AdminService {

    List<SubscriptionCard> getAll();
}
