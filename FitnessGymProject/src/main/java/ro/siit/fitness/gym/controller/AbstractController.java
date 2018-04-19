package ro.siit.fitness.gym.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class AbstractController {
<<<<<<< HEAD

    @ExceptionHandler({SecurityException.class})
    public String onSecurityException() {
=======
    @ExceptionHandler({SecurityException.class})
    public String onSecurityException(){
>>>>>>> dadc4fc6fd74d13d69d0434ba1dad2c16be43025
        return "403";
    }
}
