package ro.siit.fitness.gym.domain;

public class GymTrainer {

    private long id;
    private String firstNameTrainer;
    private String lastNameTrainer;
    private int capacity;
<<<<<<< HEAD
    private GymMember gymMember;
    private String program;
    private final int MIN_NUMBER_GYM_MEMBERS = 5;
    private final int MAX_NUMBER_GYM_MEMBERS = 20;
    private long gymMemberId;
=======
    private List<GymMember> gymMembers;
    private String program;
    private final int MIN_NUMBER_GYM_MEMBERS = 5;
    private final int MAX_NUMBER_GYM_MEMBERS = 20;
    private GymLocation gymLocation;
    private long id;
>>>>>>> 7b0f2c648a8eab772cfdf8ca8a0c80fb58e4b157

    public GymTrainer() {
    }


<<<<<<< HEAD
    public GymTrainer(String firstNameTrainer, String lastNameTrainer, int capacity, GymMember gymMember, String program) {
=======
    public GymTrainer(String firstNameTrainer, String lastNameTrainer, int capacity, List<GymMember> gymMembers, String program, GymLocation gymLocation) {
>>>>>>> 7b0f2c648a8eab772cfdf8ca8a0c80fb58e4b157
        this.firstNameTrainer = firstNameTrainer;
        this.lastNameTrainer = lastNameTrainer;
        this.capacity = capacity;
        this.gymMembers = gymMembers;
        this.program = program;
        this.gymLocation = gymLocation;
    }

    public String getFirstNameTrainer() {
        return firstNameTrainer;
    }

    public void setFirstNameTrainer(String firstNameTrainer) {
        this.firstNameTrainer = firstNameTrainer;
    }

    public String getLastNameTrainer() {
        return lastNameTrainer;
    }

    public void setLastNameTrainer(String lastNameTrainer) {
        this.lastNameTrainer = lastNameTrainer;
    }

    public int getMIN_NUMBER_GYM_MEMBERS() {
        return MIN_NUMBER_GYM_MEMBERS;
    }

    public int getMAX_NUMBER_GYM_MEMBERS() {
        return MAX_NUMBER_GYM_MEMBERS;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

<<<<<<< HEAD
    public GymMember getGymMember() {
        return gymMember;
    }

    public void setGymMember(GymMember gymMember) {
        this.gymMember = gymMember;
=======
    public List<GymMember> getGymMembers() {
        return gymMembers;
    }

    public void setGymMembers(List<GymMember> gymMembers) {
        this.gymMembers = gymMembers;
>>>>>>> 7b0f2c648a8eab772cfdf8ca8a0c80fb58e4b157
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

<<<<<<< HEAD
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGymMemberId() {
        return gymMemberId;
    }

    public void setGymMemberId(long gymMemberId) {
        this.gymMemberId = gymMemberId;
=======
    public GymLocation getGymLocation() {
        return gymLocation;
    }

    public void setGymLocation(GymLocation gymLocation) {
        this.gymLocation = gymLocation;
>>>>>>> 7b0f2c648a8eab772cfdf8ca8a0c80fb58e4b157
    }

    @Override
    public String toString() {
        return "GymTrainer{" +
                "firstNameTrainer='" + firstNameTrainer + '\'' +
                ", lastNameTrainer='" + lastNameTrainer + '\'' +
                ", capacity=" + capacity +
                ", gymMembers=" + gymMembers +
                ", program='" + program + '\'' +
                ", MIN_NUMBER_GYM_MEMBERS=" + MIN_NUMBER_GYM_MEMBERS +
                ", MAX_NUMBER_GYM_MEMBERS=" + MAX_NUMBER_GYM_MEMBERS +
                ", gymLocation=" + gymLocation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GymTrainer that = (GymTrainer) o;

        if (capacity != that.capacity) return false;
        if (MIN_NUMBER_GYM_MEMBERS != that.MIN_NUMBER_GYM_MEMBERS) return false;
        if (MAX_NUMBER_GYM_MEMBERS != that.MAX_NUMBER_GYM_MEMBERS) return false;
        if (firstNameTrainer != null ? !firstNameTrainer.equals(that.firstNameTrainer) : that.firstNameTrainer != null)
            return false;
        if (lastNameTrainer != null ? !lastNameTrainer.equals(that.lastNameTrainer) : that.lastNameTrainer != null)
            return false;
        if (gymMembers != null ? !gymMembers.equals(that.gymMembers) : that.gymMembers != null) return false;
        if (program != null ? !program.equals(that.program) : that.program != null) return false;
        return gymLocation != null ? gymLocation.equals(that.gymLocation) : that.gymLocation == null;
    }

    @Override
    public int hashCode() {
        int result = firstNameTrainer != null ? firstNameTrainer.hashCode() : 0;
        result = 31 * result + (lastNameTrainer != null ? lastNameTrainer.hashCode() : 0);
        result = 31 * result + capacity;
        result = 31 * result + (gymMembers != null ? gymMembers.hashCode() : 0);
        result = 31 * result + (program != null ? program.hashCode() : 0);
        result = 31 * result + MIN_NUMBER_GYM_MEMBERS;
        result = 31 * result + MAX_NUMBER_GYM_MEMBERS;
        result = 31 * result + (gymLocation != null ? gymLocation.hashCode() : 0);
        return result;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}