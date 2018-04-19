package ro.siit.fitness.gym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
    @RequestMapping("403")
    public String on403() {

        return "403";
    }
<<<<<<< HEAD

=======
>>>>>>> dadc4fc6fd74d13d69d0434ba1dad2c16be43025
}
