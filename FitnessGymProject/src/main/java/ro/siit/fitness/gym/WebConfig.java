package ro.siit.fitness.gym;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

<<<<<<< HEAD
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

=======
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
>>>>>>> dadc4fc6fd74d13d69d0434ba1dad2c16be43025
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
<<<<<<< HEAD
                        "classpath:/java/resources/static",
=======
                        "classpath:/java/resources/",
>>>>>>> 629b5e2c654ecad6d6040992045b78c18bd26eaa
=======
                        "classpath:/java/resources/",
>>>>>>> dadc4fc6fd74d13d69d0434ba1dad2c16be43025
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/");

    }
<<<<<<< HEAD
<<<<<<< HEAD
}
=======

}

>>>>>>> 629b5e2c654ecad6d6040992045b78c18bd26eaa
=======

}
>>>>>>> dadc4fc6fd74d13d69d0434ba1dad2c16be43025
