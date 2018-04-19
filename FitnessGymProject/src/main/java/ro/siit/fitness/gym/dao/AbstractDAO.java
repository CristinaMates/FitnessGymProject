package ro.siit.fitness.gym.dao;

import java.util.List;

public interface AbstractDAO<T> {
    List<T> getAll();

<<<<<<< HEAD
    T create(T gymMember);

    T update(T gymMember);
=======
    T create(T c);

    T update(T c);
>>>>>>> 629b5e2c654ecad6d6040992045b78c18bd26eaa
}
