package ro.siit.fitness.gym.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import ro.siit.fitness.gym.domain.Reservation;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {

    public static final org.springframework.jdbc.core.RowMapper<Reservation> RESERVATION_ROW_MAPPER = new org.springframework.jdbc.core.RowMapper<Reservation>() {
        @Override
        public Reservation mapRow(ResultSet resultSet, int i) throws SQLException {
            Reservation result = new Reservation();
            result.setId(resultSet.getLong("id"));
            result.setGymMemberID(resultSet.getLong("gym_member_id"));
            result.setGymTrainerID(resultSet.getLong("gym_trainer_id"));
            result.setProgramID(resultSet.getLong("program_id"));
            result.setPeriod(resultSet.getDate("period"));

            return result;
        }
    };
    private JdbcTemplate jdbcTemplate;


    public ReservationDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Reservation> getAll() {
        return jdbcTemplate.query("select * from reservation", RESERVATION_ROW_MAPPER);
    }

    @Override
    public Reservation create(Reservation reservation) {
        long newReservationId =  jdbcTemplate.queryForObject("insert into reservation(period, gym_member_id, gym_trainer_id, program_id) values(?, ?, ?, ?) returning id",
                new org.springframework.jdbc.core.RowMapper<Long>() {
                    @Override
                    public Long mapRow(ResultSet resultSet, int i) throws SQLException {

                        return resultSet.getLong(1);
                    }
                }, reservation.getPeriod(), reservation.getGymMemberID(), reservation.getGymTrainer().getId(),
                reservation.getProgram().getId());


        reservation.setId(newReservationId);

        return reservation;
    }

    @Override
    public Reservation update(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation findById(long id) {
        return jdbcTemplate.queryForObject("select * from reservation where id = ?",

                RESERVATION_ROW_MAPPER, id);
    }
//    private JdbcTemplate jdbcTemplate;
//
//    public ReservationDAOImpl (DataSource dataSource) {jdbcTemplate = new JdbcTemplate(dataSource); }
//
//    @Override
//    public List<Reservation> getAll() {
//
//        return jdbcTemplate.query("select * from reservations", new org.springframework.jdbc.core.RowMapper<Reservation>() {
//
//            @Override
//            public Reservation mapRow(ResultSet resultSet, int i) throws SQLException {
//
//                Reservation result = new Reservation();
//                result.setPeriod(resultSet.getDate(1));
//                result.setId(resultSet.getLong(2));
//                result.setGymMemberID(resultSet.getLong(3));
//                result.setGymTrainerID(resultSet.getLong(4));
//                return result;
//
//            }
//        });
//    }
//    @Override
//    public Reservation create(Reservation reservation) {
//
//        jdbcTemplate.update ("insert into reservations (period, id, gym_member_id, gym_trainer_id) values (?, ?, ?, ?)",
//                reservation.getPeriod(), reservation.getId(), reservation.getGymMemberID(), reservation.getGymTrainerID());
//            return reservation;
//    }
//
//    @Override
//    public Reservation update(Reservation reservation) {
//        return null;
//    }
}

