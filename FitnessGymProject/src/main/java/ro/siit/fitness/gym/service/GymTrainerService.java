package ro.siit.fitness.gym.service;

import ro.siit.fitness.gym.domain.GymTrainer;
import ro.siit.fitness.gym.domain.Program;

import java.util.List;

public interface GymTrainerService {

    List<GymTrainer> getAll();


   // String getTrainerProgram();

    Program getTrainerProgram();

    GymTrainer getTrainer();

    GymTrainer getById(long id);

    void updateTrainer(GymTrainer gymTrainer, long id);

    void createGymTrainer(GymTrainer gymTrainer);
}
