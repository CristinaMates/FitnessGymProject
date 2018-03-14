import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import ro.siit.fitness.gym.domain.GymMember;
import ro.siit.fitness.gym.domain.SubscriptionCard;
import ro.siit.fitness.gym.dto.CreateGymSubscriptionCard;
import ro.siit.fitness.gym.service.SubscriptionCardServiceImpl;

import javax.xml.bind.ValidationException;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class SubscriptionCardServiceTest {
    @After
    public void tearDown() {
        SubscriptionCardServiceImpl subscriptionCardService = new SubscriptionCardServiceImpl();
        List<SubscriptionCard> subscriptionCardList = subscriptionCardService.getAll();

        for (SubscriptionCard subscriptionCard : subscriptionCardList){
            subscriptionCardService.removeGymSubscriptionCard(subscriptionCard.getId());
        }

    }
    @Test
    public void createSubscriptionCardTest (){
        SubscriptionCardServiceImpl subscriptionCardService = new SubscriptionCardServiceImpl();
        List<SubscriptionCard> subscriptionCardList = subscriptionCardService.getAll();
        Assert.assertTrue(subscriptionCardList.isEmpty());
    }

}
