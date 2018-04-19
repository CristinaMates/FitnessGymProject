package ro.siit.fitness.gym;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
<<<<<<< HEAD
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import ro.siit.fitness.gym.dao.GymMemberDAO;
import ro.siit.fitness.gym.dao.GymMemberDAOImpl;
import ro.siit.fitness.gym.domain.GymMember;
import ro.siit.fitness.gym.domain.GymTrainer;
=======
import ro.siit.fitness.gym.dao.ReservationDAO;
import ro.siit.fitness.gym.dao.ReservationDAOImpl;
>>>>>>> dadc4fc6fd74d13d69d0434ba1dad2c16be43025

import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
public class ApplicationConfiguration implements TransactionManagementConfigurer {
<<<<<<< HEAD

    @Bean
    public GymMemberDAO gymMemberDAO() {
        return new GymMemberDAOImpl((dataSource()));
=======
    @Bean
    public ReservationDAO reservationDao_2() {
        return new ReservationDAOImpl(dataSource()));
>>>>>>> dadc4fc6fd74d13d69d0434ba1dad2c16be43025
    }


    @Bean
    public DataSource dataSource() {
        String url = new StringBuilder()
                .append("jdbc:")
                .append("postgresql")
                .append("://")
                .append("localhost")
                .append(":")
                .append("5432")
                .append("/")
                .append("fitness-gym-project")
                .append("?user=")
                .append("test")
                .append("&password=")
                .append("test").toString();

        return  new SingleConnectionDataSource(url, false);
    }

    @Bean(name="txn")
    public DataSourceTransactionManager txName() {
        return new DataSourceTransactionManager(dataSource());
    }


    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return txName();
    }

}
<<<<<<< HEAD
=======

}
>>>>>>> dadc4fc6fd74d13d69d0434ba1dad2c16be43025
