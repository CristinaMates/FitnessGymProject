package ro.siit.fitness.gym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.siit.fitness.gym.domain.Admin;
import ro.siit.fitness.gym.domain.User;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginAdminController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("auth/login");

        return modelAndView;
    }

    @RequestMapping(value = "/access-denied", method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView modelAndView = new ModelAndView("auth/access-denied");

        return modelAndView;
    }


    @RequestMapping("/onLogin")
    public ModelAndView onLogin(String username, String pass, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        ///use UserService to check the login
        boolean loginWithSuccess =  true;
        if (loginWithSuccess) {
            User user = new User();
            user.setUserName(username);
            if ("admin".equalsIgnoreCase(username)) {
                user.getRoles().add("Admin");
            }

            request.getSession().setAttribute("currentUser", user);
            modelAndView.setView(new RedirectView((String)request.getSession().getAttribute("nextUrl")));
        }

        return modelAndView;
    }
}
