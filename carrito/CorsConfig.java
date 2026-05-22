package gt.edu.carrito.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/**")
                        .allowedOrigins(
                            "http://localhost:5500",
                            "http://127.0.0.1:5500",
                            "https://6a0fb772714d96e872cc5c35--shiny-meringue-541209.netlify.app/"
                        )
                        .allowedMethods("*")
                        .allowedHeaders("*");
            }
        };
    }
}