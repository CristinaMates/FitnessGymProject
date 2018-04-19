package ro.siit.fitness.gym.dao;

import java.util.List;

public interface AbstractDAO<T> {
    List<T> getAll();

    T create(T gymMember);

    T update(T gymMember);
}
