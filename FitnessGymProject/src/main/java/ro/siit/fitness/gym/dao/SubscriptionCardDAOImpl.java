package ro.siit.fitness.gym.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.siit.fitness.gym.domain.SubscriptionCard;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SubscriptionCardDAOImpl implements SubscriptionCardDAO {

    public static final RowMapper<SubscriptionCard> SUBSCRIPTION_CARD_ROW_MAPPER = new RowMapper<SubscriptionCard>() {
        @Override
        public SubscriptionCard mapRow(ResultSet resultSet, int i) throws SQLException {
            SubscriptionCard result = new SubscriptionCard();
            result.setId(resultSet.getLong("id"));
            result.setStartDate(resultSet.getDate("start_date"));
            result.setEndDate(resultSet.getDate("end_date"));
            result.setGymMemberId(resultSet.getLong("gym_member_id"));


            return result;
        }
    };
    private JdbcTemplate jdbcTemplate;


    public SubscriptionCardDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<SubscriptionCard> getAll() {
        return jdbcTemplate.query("select * from subscription_card", SUBSCRIPTION_CARD_ROW_MAPPER);
    }

    @Override
    public SubscriptionCard create(SubscriptionCard subscriptionCard) {
        long newSubscriptionCardId =  jdbcTemplate.queryForObject("insert into subscription_card(start_date, end_date, gym_member_id) values(?, ?, ?) returning id",
                new RowMapper<Long>() {
                    @Override
                    public Long mapRow(ResultSet resultSet, int i) throws SQLException {

                        return resultSet.getLong(1);
                    }
                }, subscriptionCard.getStartDate(), subscriptionCard.getEndDate(),subscriptionCard.getGymMember().getId());


        subscriptionCard.setId(newSubscriptionCardId);

        return subscriptionCard;
    }

    @Override
    public SubscriptionCard update(SubscriptionCard subscriptionCard) {
        return null;
    }

    @Override
    public SubscriptionCard findById(long id) {
        return jdbcTemplate.queryForObject("select * from subscription_card where id = ?",

                SUBSCRIPTION_CARD_ROW_MAPPER, id);
    }

}
