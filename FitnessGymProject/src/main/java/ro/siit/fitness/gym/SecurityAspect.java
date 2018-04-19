package ro.siit.fitness.gym;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
<<<<<<< HEAD
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
=======
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
>>>>>>> dadc4fc6fd74d13d69d0434ba1dad2c16be43025
import org.springframework.stereotype.Component;
import ro.siit.fitness.gym.service.SecurityService;

import javax.annotation.security.RolesAllowed;

<<<<<<< HEAD
@Aspect
@Component
public class SecurityAspect {

    private static final Logger LOGGER= LoggerFactory.getLogger(SecurityAspect.class);
=======

@Aspect
@Component
public class SecurityAspect {
    private static final Logger LOGGER= (Logger) LoggerFactory.getLogger(SecurityAspect.class);
>>>>>>> dadc4fc6fd74d13d69d0434ba1dad2c16be43025
    //&& @annotation(auditable)
    //&& @annotation(monitoring)

    @Autowired
    private SecurityService securityService;

    @Around(value = "execution(* ro.sci.service.*.*(..)) && @annotation(rolesAllowed) ")
    public Object audit(final ProceedingJoinPoint call,
                        RolesAllowed rolesAllowed) throws Throwable {

        boolean allowed = false;
        String[] roles = rolesAllowed.value();
        if (securityService.getCurrentUser() != null
                ) {

            for (String role: roles) {
                allowed = securityService.getCurrentUser().getRoles().contains(role);
                if (allowed) {
                    break;
                }
            }
        }

        if (allowed) {
            return call.proceed();
        } else {
            throw  new SecurityException("Accessed Denied");
        }
    }
}
