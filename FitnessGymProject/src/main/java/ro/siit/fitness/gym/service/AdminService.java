package ro.siit.fitness.gym.service;

import ro.siit.fitness.gym.domain.GymMember;
import ro.siit.fitness.gym.domain.GymSubscription;


import java.util.List;

public interface AdminService {

    List<GymMember> getAll();

    void createGymMember(GymMember gymMembers);

    void updateGymMember(GymMember gymMember, long id);

    void removeGymMember(long id);

    GymMember findById(long id);

    float getDiscountedPrice(float price);
}

