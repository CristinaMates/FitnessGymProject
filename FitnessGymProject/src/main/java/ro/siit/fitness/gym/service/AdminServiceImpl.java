package ro.siit.fitness.gym.service;

import org.springframework.stereotype.Service;
import ro.siit.fitness.gym.domain.SubscriptionCard;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    public List<SubscriptionCard> cards = new ArrayList<>();

    @Override
    public List<SubscriptionCard> getAll() {
        return cards;
    }


}
