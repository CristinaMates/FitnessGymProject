package ro.siit.fitness.gym.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.siit.fitness.gym.domain.Gender;
import ro.siit.fitness.gym.domain.GymMember;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GymMemberDAOImpl implements GymMemberDAO {


    public static final RowMapper<GymMember> GYM_MEMBER_ROW_MAPPER = new RowMapper<GymMember>() {
        @Override
        public GymMember mapRow(ResultSet resultSet, int i) throws SQLException {
            GymMember result = new GymMember();
            result.setFirstName(resultSet.getString("first_name"));
            result.setLastName(resultSet.getString("last_name"));
            result.setGender(resultSet.getString("gender") != null? Gender.valueOf(resultSet.getString("gender")) : Gender.MALE);
            result.setBirthDate(resultSet.getDate("birth_date"));
            result.setTelephone(resultSet.getString("telephone"));
            result.setEmail(resultSet.getString("email"));
            result.setStudent(resultSet.getBoolean("student"));
            result.setCorporate(resultSet.getBoolean("corporate"));
            result.setId(resultSet.getLong("id"));
            result.setGymTrainerID(resultSet.getLong("gym_trainer_id"));
            result.setProgramID(resultSet.getLong("program_id"));
            result.setGymSubscriptionID(resultSet.getLong("gym_subscription_id"));



            return result;
        }
    };
    private JdbcTemplate jdbcTemplate;


    public GymMemberDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<GymMember> getAll() {
        return jdbcTemplate.query("select * from gym_member", GYM_MEMBER_ROW_MAPPER);
    }

    @Override
    public GymMember create(GymMember gymMember) {
        long newGymMemberId =  jdbcTemplate.queryForObject("insert into gym_member(first_name, last_name, gender, birth_date," +
                        " telephone, email, student, corporate, gym_trainer_id, program_id, gym_subscription_id) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) returning id",
                new RowMapper<Long>() {
                    @Override
                    public Long mapRow(ResultSet resultSet, int i) throws SQLException {

                        return resultSet.getLong(1);
                    }
                }, gymMember.getFirstName(), gymMember.getLastName(), gymMember.getGender().name(), gymMember.getBirthDate(),
                gymMember.getTelephone(), gymMember.getEmail(), gymMember.isStudent(), gymMember.isCorporate(),
                gymMember.getGymTrainer().getId(), gymMember.getProgram().getId(), gymMember.getGymSubscription().getId());


        gymMember.setId(newGymMemberId);

        return gymMember;
    }

    @Override
    public GymMember update(GymMember gymMember) {
        return null;
    }

    @Override
    public GymMember findById(long id) {
        return jdbcTemplate.queryForObject("select * from gym_member where id = ?",

                GYM_MEMBER_ROW_MAPPER, id);
    }
}
