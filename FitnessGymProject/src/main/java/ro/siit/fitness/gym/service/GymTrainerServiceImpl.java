package ro.siit.fitness.gym.service;

import org.springframework.stereotype.Service;
import ro.siit.fitness.gym.domain.GymMember;
import ro.siit.fitness.gym.domain.GymTrainer;

import java.util.ArrayList;
import java.util.List;

@Service
public class GymTrainerServiceImpl implements GymTrainerService {
    private List<GymMember> gymMembers = new ArrayList<>();

    @Override
    public List<GymMember> getAll() {
        return gymMembers;
    }

    @Override
    public String getTrainerProgram() {
        GymTrainer gymTrainer = new GymTrainer();
        return gymTrainer.getProgram();
    }


}
