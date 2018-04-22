package ro.siit.fitness.gym.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import ro.siit.fitness.gym.domain.GymTrainer;
import ro.siit.fitness.gym.domain.SubscriptionCard;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GymTrainerDAOImpl implements GymTrainerDAO {

    private JdbcTemplate jdbcTemplate;
    public GymTrainerDAOImpl (DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<GymTrainer> getAll() {
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


    }

    @Override
    public GymTrainer create(GymTrainer t) {
        jdbcTemplate.update("insert into gym_trainers(first_name_trainer, last_name_trainer, program, capacity, gym_member_id) values(?, ?, ?, ?, ?)",
              t.getFirstNameTrainer(),t.getLastNameTrainer(),t.getProgram(),t.getCapacity(), t.getGymMemberId());
        return t;
    }

    @Override
    public GymTrainer update(GymTrainer t) {
        return null;
    }
}
