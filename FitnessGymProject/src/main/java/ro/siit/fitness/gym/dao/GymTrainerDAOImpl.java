package ro.siit.fitness.gym.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.siit.fitness.gym.domain.GymTrainer;
import ro.siit.fitness.gym.domain.SubscriptionCard;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GymTrainerDAOImpl implements GymTrainerDAO {
    public static final RowMapper<GymTrainer> GYMTRAINER_ROW_MAPPER = new RowMapper<GymTrainer>() {
        @Override
        public GymTrainer mapRow(ResultSet resultSet, int i) throws SQLException {
            GymTrainer result = new GymTrainer();
            result.setFirstName(resultSet.getString("first_name"));
            result.setLastName(resultSet.getString("last_name"));
            result.setTelephone(resultSet.getString("telephone"));
            result.setId(resultSet.getLong("id"));

            return result;
        }
    };
    private JdbcTemplate jdbcTemplate;


    public CustodianDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<GymTrainer> getAll() {
<<<<<<< HEAD
        return jdbcTemplate.query("select * from gym_trainer", GYMTRAINER_ROW_MAPPER);
=======
        return jdbcTemplate.query("select * from gym_trainers", new org.springframework.jdbc.core.RowMapper<GymTrainer>() {
            @Override
            public GymTrainer mapRow(ResultSet resultSet, int i) throws SQLException {

                GymTrainer result = new GymTrainer();
                result.setId(resultSet.getLong(1));
                result.setFirstNameTrainer(resultSet.getString(2));
                result.setLastNameTrainer(resultSet.getString(3));
                result.setCapacity(resultSet.getInt(4));
                result.setProgram(resultSet.getString(5));
                result.setGymMemberId(resultSet.getLong(6));
                return result;
            }
        });


>>>>>>> 754de52607da0867f71f75a8979530726dee7181
    }

    @Override
    public GymTrainer create(GymTrainer gymTrainer) {
        long newCustodianId = jdbcTemplate.queryForObject("insert into gym_trainer(first_name, last_name, telephone) values(?, ?, ?) returning id",
                new RowMapper<Long>() {
                    @Override
                    public Long mapRow(ResultSet resultSet, int i) throws SQLException {

                        return resultSet.getLong(1);
                    }
                }, gymTrainer.getFirstName(), gymTrainer.getLastName(),
                gymTrainer.getTelephone());

        gymTrainer.setId(newCustodianId);

//        if (true) {
//            throw new RuntimeException("Force rollback");
//        }
        return gymTrainer;
    }

    @Override
    public GymTrainer findById(long id) {
        return jdbcTemplate.queryForObject("select * from gym_trainer where id = ?",

                GYMTRAINER_ROW_MAPPER, id);
    }
}


