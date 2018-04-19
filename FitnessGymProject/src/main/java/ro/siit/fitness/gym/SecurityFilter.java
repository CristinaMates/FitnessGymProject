package ro.siit.fitness.gym;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.siit.fitness.gym.domain.Admin;
=======

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
>>>>>>> dadc4fc6fd74d13d69d0434ba1dad2c16be43025
import ro.siit.fitness.gym.domain.User;
import ro.siit.fitness.gym.service.SecurityService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SecurityFilter implements javax.servlet.Filter {


    @Autowired
    private SecurityService securityService;

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {


        User user = (User) ((HttpServletRequest) request).getSession().getAttribute("currentUser");

        securityService.setCurrentUser(user);

        String url = ((HttpServletRequest) request).getRequestURL().toString();

        if (!url.toLowerCase().contains("login")) {
            if (user == null) {

                ((HttpServletRequest) request)
                        .getSession().setAttribute("nextUrl", url);
                HttpServletResponse servletResponse = (HttpServletResponse) response;
                //servletResponse.sendError(401);
                servletResponse.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
                servletResponse.setHeader("Location", "/login");
                return;
            } else {
                //if authorized do nothing
//				if (false) {
//					//not authorized
//						HttpServletResponse servletResponse = (HttpServletResponse) response;
//						servletResponse.sendError(401);
//						return;
//				}
            }
        }

        // System.out.println("Thread name: " + Thread.currentThread().getName()
        // +
        // ", current user: " + (user != null ? user.getUserName() : null));
        //
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }
}
<<<<<<< HEAD
=======

>>>>>>> dadc4fc6fd74d13d69d0434ba1dad2c16be43025
