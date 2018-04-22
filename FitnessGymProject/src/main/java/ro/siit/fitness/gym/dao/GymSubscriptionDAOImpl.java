package ro.siit.fitness.gym.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.siit.fitness.gym.domain.GymSubscription;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GymSubscriptionDAOImpl implements GymSubscriptionDAO{

    public static final RowMapper<GymSubscription> GYM_SUBSCRIPTION_ROW_MAPPER = new RowMapper<GymSubscription>() {
        @Override
        public GymSubscription mapRow(ResultSet resultSet, int i) throws SQLException {
            GymSubscription result = new GymSubscription();
            result.setId(resultSet.getLong("id"));
            result.setType(resultSet.getString("type"));
            result.setPrice(resultSet.getFloat("price"));
            result.setDiscount(resultSet.getFloat("discount"));
            result.setStartDate(resultSet.getDate("start_date"));
            result.setEndDate(resultSet.getDate("end_date"));

            return result;
        }
    };
    private JdbcTemplate jdbcTemplate;


    public GymSubscriptionDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<GymSubscription> getAll() {
        return jdbcTemplate.query("select * from gym_subscription", GYM_SUBSCRIPTION_ROW_MAPPER);
    }

    @Override
    public GymSubscription create(GymSubscription gymSubscription) {
        long newGymSubscriptionId =  jdbcTemplate.queryForObject("insert into gym_subscription(type, price, discount, start_date, end_date) values(?, ?, ?, ?, ?) returning id",
                new RowMapper<Long>() {
                    @Override
                    public Long mapRow(ResultSet resultSet, int i) throws SQLException {

                        return resultSet.getLong(1);
                    }
                }, gymSubscription.getType(), gymSubscription.getPrice(), gymSubscription.getDiscount(), gymSubscription.getStartDate(),
                gymSubscription.getEndDate());


        gymSubscription.setId(newGymSubscriptionId);

        return gymSubscription;
    }

    @Override
    public GymSubscription update(GymSubscription gymSubscription) {
        return null;
    }

    @Override
    public GymSubscription findById(long id) {
        return jdbcTemplate.queryForObject("select * from gym_subscription where id = ?",

                GYM_SUBSCRIPTION_ROW_MAPPER, id);
    }
}
