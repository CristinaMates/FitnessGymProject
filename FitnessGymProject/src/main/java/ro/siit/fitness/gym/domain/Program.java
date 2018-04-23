package ro.siit.fitness.gym.domain;

public class Program {

    private long id;
    private GymTrainer gymTrainer;
    private String classes;
    private int numberOfGymMembers;
    private final int MIN_NUMBER_GYM_MEMBERS = 5;
    private final int MAX_NUMBER_GYM_MEMBERS = 20;

    public Program() {
    }

    public Program(long id, GymTrainer gymTrainer, String classes, int numberOfGymMembers) {
        this.id = id;
        this.gymTrainer = gymTrainer;
        this.classes = classes;
        this.numberOfGymMembers = numberOfGymMembers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public int getNumberOfGymMembers() {
        return numberOfGymMembers;
    }

    public void setNumberOfGymMembers(int numberOfGymMembers) {
        this.numberOfGymMembers = numberOfGymMembers;
    }

    public int getMIN_NUMBER_GYM_MEMBERS() {
        return MIN_NUMBER_GYM_MEMBERS;
    }

    public int getMAX_NUMBER_GYM_MEMBERS() {
        return MAX_NUMBER_GYM_MEMBERS;
    }

    public GymTrainer getGymTrainer() {
        return gymTrainer;
    }

    public void setGymTrainer(GymTrainer gymTrainer) {
        this.gymTrainer = gymTrainer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Program program1 = (Program) o;

        if (id != program1.id) return false;
        if (MIN_NUMBER_GYM_MEMBERS != program1.MIN_NUMBER_GYM_MEMBERS) return false;
        if (MAX_NUMBER_GYM_MEMBERS != program1.MAX_NUMBER_GYM_MEMBERS) return false;
        if (gymTrainer != null ? !gymTrainer.equals(program1.gymTrainer) : program1.gymTrainer != null) return false;
        return classes != null ? classes.equals(program1.classes) : program1.classes == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (gymTrainer != null ? gymTrainer.hashCode() : 0);
        result = 31 * result + (classes != null ? classes.hashCode() : 0);
        result = 31 * result + MIN_NUMBER_GYM_MEMBERS;
        result = 31 * result + MAX_NUMBER_GYM_MEMBERS;
        return result;
    }
}
