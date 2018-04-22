package ro.siit.fitness.gym.domain;

public class GymTrainer {

    private long id;
    private String firstName;
    private String lastName;
    private long gymMemberId;

    public GymTrainer() {
    }

    public GymTrainer(long id, String firstName, String lastName, GymMember gymMember, long gymMemberId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gymMemberId = gymMemberId;
    }





}