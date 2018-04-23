package ro.siit.fitness.gym.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.siit.fitness.gym.domain.GymMember;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GymMemberDAOImpl implements GymMemberDAO {
    private JdbcTemplate jdbcTemplate;


    public GymMemberDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<GymMember> getAll() {
        return jdbcTemplate.query("select * from gym_members", new RowMapper<GymMember>() {
            @Override
            public GymMember mapRow(ResultSet resultSet, int i) throws SQLException {

                GymMember result = new GymMember();
                result.setFirstName(resultSet.getString(1));
                result.setLastName(resultSet.getString(2));
                result.setGender(resultSet.getString(3));
                result.setBirthDate(resultSet.getDate(4));
                result.setId(resultSet.getLong(5));
                result.setTelephone(resultSet.getString(6));
                result.setEmail(resultSet.getString(7));
                result.setStudent(resultSet.getBoolean(8));
                result.setCorporate(resultSet.getBoolean(9));
                result.setGymTrainerID(resultSet.getLong(10));
                result.setGymSubscriptionID(resultSet.getLong(11));

                return result;
            }
        });
    }

    @Override
    public GymMember create(GymMember gymMember) {
        jdbcTemplate.update("insert into gym_members(first_name, last_name, gender, birth_date, telephone, email, student, corporate, gym_trainer_id, gym_subscription_id)" +
                        " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                gymMember.getFirstName(), gymMember.getLastName(), gymMember.getGender(), gymMember.getBirthDate(), gymMember.getId(),
                gymMember.getEmail(), gymMember.isStudent(), gymMember.isCorporate(), gymMember.getGymTrainerID(), gymMember.getGymSubscriptionID());
        return gymMember;
    }

    @Override
    public GymMember update(GymMember gymMember) {
        return null;
    }

}
