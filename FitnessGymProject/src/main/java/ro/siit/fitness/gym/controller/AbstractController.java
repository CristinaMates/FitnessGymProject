package ro.siit.fitness.gym.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class AbstractController {

    @ExceptionHandler({SecurityException.class})
    public String onSecurityException() {
        return "403";
    }
}
