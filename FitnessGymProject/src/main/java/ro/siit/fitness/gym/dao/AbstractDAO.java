package ro.siit.fitness.gym.dao;

import java.util.List;

public interface AbstractDAO<T> {
    List<T> getAll();

<<<<<<< HEAD
<<<<<<< HEAD
    T create(T gymMember);

    T update(T gymMember);
=======
    T create(T c);

    T update(T c);
>>>>>>> 629b5e2c654ecad6d6040992045b78c18bd26eaa
=======
    T create(T c);

    T update(T c);
>>>>>>> dadc4fc6fd74d13d69d0434ba1dad2c16be43025
}
