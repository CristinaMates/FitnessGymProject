package ro.siit.fitness.gym.service;

import org.springframework.stereotype.Service;
import ro.siit.fitness.gym.domain.GymTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GymTrainerServiceImpl implements GymTrainerService {
    private List<GymTrainer> gymTrainers = new ArrayList<>();

    @Override
    public List<GymTrainer> getAll() {
        return gymTrainers;
    }

//    @Override
//    public String getTrainerProgram() {
////        GymTrainer gymTrainer = new GymTrainer();
////        return gymTrainer.getProgram();
//    }

    @Override
    public GymTrainer getTrainer() {
        GymTrainer gymTrainer = new GymTrainer();
        return gymTrainer;
    }

    @Override
    public GymTrainer getById(long id) {
        return gymTrainers.stream().filter(c -> c.getId() == id).collect(Collectors.toList()).get(0);
    }

    @Override
    public void updateTrainer(GymTrainer gymTrainer, long id) {
        gymTrainers = gymTrainers.stream().filter(c -> c.getId() != id).collect(Collectors.toList());
        gymTrainer.setId(id);
        gymTrainers.add(gymTrainer);
    }

    @Override
    public void createGymTrainer(GymTrainer gymTrainer) {
        gymTrainer.setId(System.currentTimeMillis());
        gymTrainers.add(gymTrainer);
    }


}
