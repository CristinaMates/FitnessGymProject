package ro.siit.fitness.gym;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.siit.fitness.gym.dao.ReservationDAO;
import ro.siit.fitness.gym.dao.ReservationDAOImpl;

import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
public class ApplicationConfiguration implements TransactionManagementConfigurer {
    @Bean
    public ReservationDAO reservationDao_2() {
        return new ReservationDAOImpl(dataSource()));
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

}
