package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration// to make this class Configuration class
@ComponentScan("com.tpe")//to scan beans from the package specified .
@EnableWebMvc////@EnableWebMvc is an annotation in Spring Framework that is used to enable Spring MVC configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean////InternalResourceViewResolver is a Spring MVC class that resolves the views (templates) used to render the response for a request.
    public InternalResourceViewResolver resolver(){
        InternalResourceViewResolver resolver= new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);//which is a class in the Java Standard Tag Library (JSTL) used to simplify writing JSP pages
        resolver.setPrefix("/WEB-INF/views/");////property to the location of the view files
        resolver.setSuffix(".jsp");        // property to the file extension of the view files.
        return resolver;
    }
    // we are setting the location of our resources(CSS,image)
    @Override////This method is used to configure how static resources, such as images,
                // CSS, and JavaScript files, are handled by the application.
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/resources/**").  ////http://localhost:8080/SpringMvc/resources/css/style.css
                addResourceLocations("/resources/").//method specifies the location of resources.
                setCachePeriod(0);////used to specify the duration for which the resources should be cached
    }
}
