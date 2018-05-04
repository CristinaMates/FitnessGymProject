package ro.siit.fitness.gym.dao;

import ro.siit.fitness.gym.domain.Program;

public interface ProgramDAO extends AbstractDAO<Program> {

    Program findById(long id);
}
