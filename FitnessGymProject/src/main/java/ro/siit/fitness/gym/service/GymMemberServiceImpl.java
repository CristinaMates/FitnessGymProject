package ro.siit.fitness.gym.service;

import org.springframework.stereotype.Service;
import ro.siit.fitness.gym.domain.GymMember;

import java.util.ArrayList;
import java.util.List;

@Service
public class GymMemberServiceImpl implements GymMemberService {
    private List<GymMember> gymMembers = new ArrayList<>();

    @Override
    public List<GymMember> getAll() {
        return gymMembers;
    }

    @Override
    public void createGymMember(GymMember gymMember) {
        gymMembers.add(gymMember);
    }
}
