package ro.siit.fitness.gym.service;

import ro.siit.fitness.gym.domain.GymMember;

import java.util.List;

public interface GymTrainerService {

    List<GymMember> getAll();

    String getTrainerProgram();

}
