package ro.siit.fitness.gym.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.siit.fitness.gym.domain.GymTrainer;
import ro.siit.fitness.gym.domain.Program;


import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GymTrainerDAOImpl implements GymTrainerDAO {

    public static final RowMapper<GymTrainer> GYM_TRAINER_ROW_MAPPER = new RowMapper<GymTrainer>() {
        @Override
        public GymTrainer mapRow(ResultSet resultSet, int i) throws SQLException {
            GymTrainer result = new GymTrainer();
            result.setFirstNameTrainer(resultSet.getString("first_name"));
            result.setLastNameTrainer(resultSet.getString("last_name"));
            //result.setProgramId(resultSet.getLong("program_id"));
            result.setId(resultSet.getLong("id"));


            return result;
        }
    };
    private JdbcTemplate jdbcTemplate;


    public GymTrainerDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<GymTrainer> getAll() {
        return jdbcTemplate.query("select * from gym_trainer", GYM_TRAINER_ROW_MAPPER);
    }

    @Override
    public GymTrainer create(GymTrainer gymTrainer) {
        long newGymTrainerId = jdbcTemplate.queryForObject("insert into gym_trainer(first_name, last_name) values(?, ?) returning id",
                new RowMapper<Long>() {
                    @Override
                    public Long mapRow(ResultSet resultSet, int i) throws SQLException {

                        return resultSet.getLong(1);
                    }
                }, gymTrainer.getFirstNameTrainer(), gymTrainer.getLastNameTrainer());


        gymTrainer.setId(newGymTrainerId);

        return gymTrainer;
    }


    @Override
    public GymTrainer update(GymTrainer gymTrainer) {
        return null;
    }

    @Override
    public GymTrainer findById(long id) {
        return jdbcTemplate.queryForObject("select * from gym_trainer where id = ?",

                GYM_TRAINER_ROW_MAPPER, id);
    }
}
