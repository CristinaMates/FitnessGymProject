package ro.siit.fitness.gym.service;

import ro.siit.fitness.gym.domain.GymMember;

import java.util.List;

public interface GymMemberService {

    List<GymMember> getAll();

    void createGymMember(GymMember gymMember);

}
