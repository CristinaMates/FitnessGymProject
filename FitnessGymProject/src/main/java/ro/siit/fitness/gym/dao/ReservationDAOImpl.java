package ro.siit.fitness.gym.dao;

import ro.siit.fitness.gym.domain.Reservation;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    private JdbcTemplate jdbcTemplate;

    public ReservationDAOImpl (DataSource dataSource) {jdbcTemplate = new JdbcTemplate (dataSource); }

    @Override
    public List<Reservation> getAll() {

        return jdbcTemplate.query("select * from reservations", new RowMapper<Reservation>(){
            @Override
            public Reservation mapRow (ResultSet resultSet, int i) throws SQLException {

                Reservation result = new Reservation();
                result.setPeriod(resultSet.getDate(1));
                result.setId(resultSet.getLong(2));
                result.setGymMemberID(resultSet.getLong(3));
                result.setGymTrainerID(resultSet.getLong(4));
                return result;

            }
        });

    @Override
    public Reservation create(Reservation reservation) {

        jdbcTemplate.update ("insert into reservations (period, id, gym_member_id, gym_trainer_id) values (?, ?, ?, ?)",
                reservation.getPeriod(), reservation.getId(), reservation.getGymMemberID(), reservation.getGymTrainerID());
            return reservation;
    }

    @Override
    public Reservation update(Reservation reservation) {
        return null;
    }
}

