package ro.siit.fitness.gym.service;

import ro.siit.fitness.gym.domain.GymMember;

import java.util.List;

public interface GymMemberService {

    List<GymMember> getAll();

    void createGymMember(GymMember gymMembers);

    void updateGymMember(GymMember gymMember, long id);

    void removeGymMember(long id);

    GymMember getById(long id);


}
