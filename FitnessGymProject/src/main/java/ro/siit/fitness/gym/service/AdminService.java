package ro.siit.fitness.gym.service;

import ro.siit.fitness.gym.domain.GymMember;
import ro.siit.fitness.gym.domain.GymSubscription;


import java.util.List;

public interface AdminService {

    List<GymMember> getAll();

    List<GymSubscription> getAllTypes();

    void createGymMember(GymMember gymMembers);

    void updateGymMember(GymMember gymMember, long id);

    void removeGymMember(long id);

    GymMember getById(long id);

    float getDiscountedPrice(float price);
}

