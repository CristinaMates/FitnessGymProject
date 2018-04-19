package ro.siit.fitness.gym;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

<<<<<<< HEAD
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter{
=======
/**
 * created a WebConfig class for WebMvc in order to set the path for the resources
 * needed to be used in the view layer (css, js, img files)
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
>>>>>>> 629b5e2c654ecad6d6040992045b78c18bd26eaa

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/webjars/**", "/resources/**",
                "/img/**",
                "/css/**",
                "/js/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
<<<<<<< HEAD
                        "classpath:/java/resources/static",
=======
                        "classpath:/java/resources/",
>>>>>>> 629b5e2c654ecad6d6040992045b78c18bd26eaa
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/");

    }
<<<<<<< HEAD
}
=======

}

>>>>>>> 629b5e2c654ecad6d6040992045b78c18bd26eaa
