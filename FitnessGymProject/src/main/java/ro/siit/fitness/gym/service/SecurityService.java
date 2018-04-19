package ro.siit.fitness.gym.service;

import org.springframework.stereotype.Component;
import ro.siit.fitness.gym.domain.User;

@Component
public class SecurityService {
    private ThreadLocal<User> currentUser;

    public void setCurrentUser(User user) {
        this.currentUser = new ThreadLocal<>();
        this.currentUser.set(user);
    }

    public User getCurrentUser() {
        return this.currentUser != null ?
                this.currentUser.get() : null;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 7b0f2c648a8eab772cfdf8ca8a0c80fb58e4b157
