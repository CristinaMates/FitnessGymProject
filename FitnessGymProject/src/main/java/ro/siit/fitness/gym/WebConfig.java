package ro.siit.fitness.gym;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


    /**
     * created a WebConfig class for WebMvc in order to set the path for the resources
     * needed to be used in the view layer (css, js, img files)
     */

    @Configuration
    @EnableWebMvc
    public class WebConfig extends WebMvcConfigurerAdapter {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler(
                    "/webjars/**", "/resources/**",
                    "/img/**",
                    "/css/**",
                    "/js/**")
                    .addResourceLocations(
                            "classpath:/META-INF/resources/webjars/",
                            "classpath:/java/resources/static",
                            "classpath:/java/resources/",
                            "classpath:/java/resources/",
                            "classpath:/static/img/",
                            "classpath:/static/css/",
                            "classpath:/static/js/");

        }
    }