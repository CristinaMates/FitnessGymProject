package ro.siit.fitness.gym.service;

import org.springframework.stereotype.Service;
import ro.siit.fitness.gym.domain.GymMember;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GymMemberServiceImpl implements GymMemberService {
    private List<GymMember> gymMembers = new ArrayList<>();

    @Override
    public List<GymMember> getAll() {
        return gymMembers;
    }

    @Override
    public void createGymMember(GymMember gymMember) {
        gymMember.setId(System.currentTimeMillis());
        gymMembers.add(gymMember);
    }

    @Override
    public void updateGymMember(GymMember gymMember, long id) {
        gymMembers = gymMembers.stream().filter(c -> c.getId() != id).collect(Collectors.toList());
        gymMember.setId(id);
        gymMembers.add(gymMember);
    }

    @Override
    public void removeGymMember(long id) {
        gymMembers = gymMembers.stream().filter(c -> c.getId() != id).collect(Collectors.toList());
    }

    @Override
    public GymMember getById(long id) {

        return gymMembers.stream().filter(c -> c.getId() == id).collect(Collectors.toList()).get(0);
    }
}
