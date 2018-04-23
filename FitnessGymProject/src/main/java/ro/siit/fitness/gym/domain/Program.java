package ro.siit.fitness.gym.domain;

public class Program {

    private long id;
    private GymTrainer gymTrainer;
    private String program;
    private final int MIN_NUMBER_GYM_MEMBERS = 5;
    private final int MAX_NUMBER_GYM_MEMBERS = 20;


    public Program(long id, GymTrainer gymTrainer, String program) {
        this.id = id;
        this.gymTrainer = gymTrainer;
        this.program = program;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
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
        return program != null ? program.equals(program1.program) : program1.program == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (gymTrainer != null ? gymTrainer.hashCode() : 0);
        result = 31 * result + (program != null ? program.hashCode() : 0);
        result = 31 * result + MIN_NUMBER_GYM_MEMBERS;
        result = 31 * result + MAX_NUMBER_GYM_MEMBERS;
        return result;
    }
}
