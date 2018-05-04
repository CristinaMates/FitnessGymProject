package ro.siit.fitness.gym.service;

import ro.siit.fitness.gym.domain.GymTrainer;

import java.util.List;

public interface GymTrainerService {

    List<GymTrainer> getAll();

   // String getTrainerProgram();

    GymTrainer getTrainer();

    GymTrainer getById(long id);

    void updateTrainer(GymTrainer gymTrainer, long id);

    void createGymTrainer(GymTrainer gymTrainer);
}
