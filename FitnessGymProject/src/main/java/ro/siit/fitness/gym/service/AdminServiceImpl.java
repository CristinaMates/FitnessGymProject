package ro.siit.fitness.gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.fitness.gym.dao.GymMemberDAO;
import ro.siit.fitness.gym.dao.GymSubscriptionDAO;
import ro.siit.fitness.gym.dao.GymTrainerDAO;
import ro.siit.fitness.gym.dao.ProgramDAO;
import ro.siit.fitness.gym.domain.GymMember;
import ro.siit.fitness.gym.domain.GymSubscription;
import ro.siit.fitness.gym.domain.GymTrainer;
import ro.siit.fitness.gym.domain.Program;

import javax.annotation.security.RolesAllowed;
import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private GymMemberDAO gymMemberDAO;

    @Autowired
    private GymTrainerDAO gymTrainerDAO;

    @Autowired
    private GymSubscriptionDAO gymSubscriptionDAO;

    @Autowired
    private ProgramDAO programDAO;

    @Override
    @RolesAllowed({"Admin", "User"})
    public List<GymMember> getAll() {
        List<GymMember> gymMembers = gymMemberDAO.getAll();

            for (GymMember member: gymMembers) {
                solve(member);
            }

        return gymMembers;
    }

    private void solve(GymMember gymMember) {
        gymMember.setGymTrainer(gymTrainerDAO.findById(gymMember.getGymTrainerID()));
        gymMember.setProgram(programDAO.findById(gymMember.getProgramID()));
        gymMember.setGymSubscription(gymSubscriptionDAO.findById(gymMember.getGymSubscriptionID()));
    }


    @Override
    public void createGymMember(GymMember gymMember) {
        GymTrainer gymTrainer = gymTrainerDAO.create(gymMember.getGymTrainer());
        gymMember.setGymTrainer(gymTrainer);

        Program program = programDAO.create(gymMember.getProgram());
        gymMember.setProgram(program);

        GymSubscription gymSubscription = gymSubscriptionDAO.create(gymMember.getGymSubscription());
        gymMember.setGymSubscription(gymSubscription);

        gymMemberDAO.create(gymMember);

    }

    @Override
    public void updateGymMember(GymMember gymMember, long id) {

        gymMemberDAO.update(gymMember);
    }

    @Override
    public void removeGymMember(long id) {
     //   gymMembers = gymMembers.stream().filter(c -> c.getId() != id).collect(Collectors.toList());
    }

    @Override
    public GymMember findById(long id) {
        GymMember m =  gymMemberDAO.findById(id);
        solve(m);
        return m;
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
