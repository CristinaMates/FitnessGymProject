package ro.siit.fitness.gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.fitness.gym.domain.GymMember;
import ro.siit.fitness.gym.domain.GymSubscription;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {
    private List<GymMember> gymMembers = new ArrayList<>();
    private List<GymSubscription> gymSubscriptions = new ArrayList<>();

    @Autowired
    private SecurityService securityService;

    @Override
    @RolesAllowed({"Admin", "User"})
    public List<GymMember> getAll() {
        return gymMembers;
    }

    @Override
    public List<GymSubscription> getAllTypes() {
        return gymSubscriptions;
    }

    @Override
    public void createGymMember(GymMember gymMember) {
        gymMember.setId(System.currentTimeMillis());
        gymMembers.add(gymMember);
    }

    @Override
    public void updateGymMember(GymMember gymMember, long id) {
        gymMembers = gymMembers.stream().filter(c -> c.getId() != id).collect(Collectors.toList());
        gymMember.setId(id);
        gymMembers.add(gymMember);
    }

    @Override
    public void removeGymMember(long id) {
        gymMembers = gymMembers.stream().filter(c -> c.getId() != id).collect(Collectors.toList());
    }

    @Override
    public GymMember getById(long id) {

        return gymMembers.stream().filter(c -> c.getId() == id).collect(Collectors.toList()).get(0);
    }

    @Override
    public float getDiscountedPrice(float price) {
        GymMember gymMember = new GymMember();
        if (gymMember.isStudent()) {
            price = price - 0.3f * price;
        } else {
            if (gymMember.isCorporate()) {
                price = price - 0.7f * price;
            }else{
                return price;
            }
        }
        return price;
    }
}
