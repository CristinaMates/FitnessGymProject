package ro.siit.fitness.gym.domain;

import java.util.LinkedList;
import java.util.List;

public class User {
<<<<<<< HEAD

=======
>>>>>>> dadc4fc6fd74d13d69d0434ba1dad2c16be43025
    List<String> roles = new LinkedList<>();

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
