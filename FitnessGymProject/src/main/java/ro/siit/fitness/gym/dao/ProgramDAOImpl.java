package ro.siit.fitness.gym.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.siit.fitness.gym.domain.Program;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProgramDAOImpl implements ProgramDAO {
    public static final RowMapper<Program> PROGRAM_ROW_MAPPER = new RowMapper<Program>() {
        @Override
        public Program mapRow(ResultSet resultSet, int i) throws SQLException {
            Program result = new Program();
            result.setId(resultSet.getLong("id"));
            result.setClasses(resultSet.getString("program"));
            result.setNumberOfGymMembers(resultSet.getInt("number_gym_member"));


            return result;
        }
    };
    private JdbcTemplate jdbcTemplate;


    public ProgramDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Program> getAll() {
        return jdbcTemplate.query("select * from gym_subscription", PROGRAM_ROW_MAPPER);
    }

    @Override
    public Program create(Program program) {
        long newProgramId =  jdbcTemplate.queryForObject("insert into program(program, number_gym_member) values(?, ?) returning id",
                new RowMapper<Long>() {
                    @Override
                    public Long mapRow(ResultSet resultSet, int i) throws SQLException {

                        return resultSet.getLong(1);
                    }
                }, program.getClasses(), program.getNumberOfGymMembers());


        program.setId(newProgramId);

        return program;
    }

    @Override
    public Program update(Program program) {
        return null;
    }

    @Override
    public Program findById(long id) {
        return jdbcTemplate.queryForObject("select * from program where id = ?",

                PROGRAM_ROW_MAPPER, id);
    }

}
