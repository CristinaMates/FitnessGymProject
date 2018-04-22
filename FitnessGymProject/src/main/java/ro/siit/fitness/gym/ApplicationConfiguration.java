package ro.siit.fitness.gym;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import ro.siit.fitness.gym.dao.GymTrainerDAO;
import ro.siit.fitness.gym.dao.GymTrainerDAOImpl;
import ro.siit.fitness.gym.dao.SubscriptionCardDAO;
import ro.siit.fitness.gym.dao.SubscriptionCardDAOImpl;
import ro.siit.fitness.gym.domain.GymMember;

import javax.sql.DataSource;
@EnableTransactionManagement
@Configuration
public class ApplicationConfiguration implements TransactionManagementConfigurer {

    @Bean
    public SubscriptionCardDAO subscriptionCardDAO() {
        return new SubscriptionCardDAOImpl(dataSource());
    }


   @Bean
   public GymTrainerDAO gymTrainerDAO () {
        return new GymTrainerDAOImpl(dataSource());
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
                .append("postgres")
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


